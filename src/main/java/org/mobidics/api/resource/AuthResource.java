package org.mobidics.api.resource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.glassfish.jersey.internal.util.Base64;
import org.mobidics.api.viewmodel.UserViewModel;
import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Long Bui on 08.05.17.
 * E-Mail: longbui1992@gmail.com
 */
@Path("/auth")
public class AuthResource
{
    private static String SECRET = "MobiDicsAPISSecret";
    private static String AUTHORIZATION = "Authorization";
    private static String AUTHORIZATION_SCHEME = "Basic";
    public static String ISSUER = "mobidics";
    public static String USERNAME_CLAIM = "username";
    public static String ROLE_CLAIM = "role";
    public static String JWT_HEADER = "X-mobidics-jwt-token";
    public static Algorithm AUTH_ALGORITHM = null;

    static
    {
        try
        {
            AUTH_ALGORITHM = Algorithm.HMAC256(SECRET);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    @Context
    ContainerRequestContext requestContext;

    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateToken()
    {
        String authorizationHeader = requestContext.getHeaderString(AUTHORIZATION);
        if (authorizationHeader == null || authorizationHeader.isEmpty())
        {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        String[] splitUserPass = extractUserPassFromHeader(authorizationHeader);
        if (splitUserPass.length != 2)
        {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        String username = splitUserPass[0];
        String password = splitUserPass[1];
        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticateUser(username, password);
        if (user == null)
        {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        String token;
        try
        {
            token = generateJWT(user);
        }
        catch (UnsupportedEncodingException e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(new UserViewModel(user))
                       .header(JWT_HEADER, token)
                       .build();
    }

    private String generateJWT(User user) throws UnsupportedEncodingException
    {
        String token;
        token = JWT.create()
                   .withIssuer(ISSUER)
                   .withExpiresAt(Date.from(LocalDateTime.now()
                                                         .plusWeeks(1)
                                                         .atZone(ZoneId.systemDefault())
                                                         .toInstant()))
                   .withClaim(USERNAME_CLAIM, user.getUsername())
                   .withClaim(ROLE_CLAIM, user.getUserLevel())
                   .sign(AUTH_ALGORITHM);
        return token;
    }

    private String[] extractUserPassFromHeader(String authorizationHeader)
    {
        String encodedUserPass = authorizationHeader.replaceFirst(AUTHORIZATION_SCHEME + " ", "");
        String userPass = new String(Base64.decode(encodedUserPass.getBytes()));
        return userPass.split(":");
    }
}
