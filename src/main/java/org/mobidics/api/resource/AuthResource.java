package org.mobidics.api.resource;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.glassfish.jersey.internal.util.Base64;
import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

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
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Path("/auth")
public class AuthResource
{
    private static String SECRET = "MobiDicsAPISSecret";
    private static String AUTHORIZATION = "Authorization";
    private static String AUTHORIZATION_SCHEME = "Basic";
    private static String ISSUER = "mobidics";
    public static String USERNAME_CLAIM = "username";
    public static String ROLE_CLAIM = "role";
    public static String JWT_HEADER = "X-mobidics-jwt-token";

    @Context
    ContainerRequestContext requestContext;

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
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.ok(user)
                       .header(JWT_HEADER, token)
                       .build();
    }

    private String generateJWT(User user) throws UnsupportedEncodingException
    {
        String token;Algorithm algorithm = Algorithm.HMAC256(SECRET);
        token = JWT.create()
                   .withIssuer(ISSUER)
                   .withExpiresAt(Date.from(LocalDateTime.now()
                                                         .plusWeeks(1)
                                                         .atZone(ZoneId.systemDefault())
                                                         .toInstant()))
                   .withClaim(USERNAME_CLAIM, user.getUsername())
                   .withClaim(ROLE_CLAIM, user.getUserLevel())
                   .sign(algorithm);
        return token;
    }

    private String[] extractUserPassFromHeader(String authorizationHeader)
    {
        String encodedUserPass = authorizationHeader.replaceFirst(AUTHORIZATION_SCHEME + " ", "");
        String userPass = new String(Base64.decode(encodedUserPass.getBytes()));
        return userPass.split(":");
    }
}
