package org.mobidics.api.filter.auth;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mobidics.api.resource.AuthResource.*;

/**
 * Created by Long Bui on 01.03.17.
 * E-Mail: longbui1992@gmail.com
 */
@Provider
public class AuthenticationRequestFilter implements ContainerRequestFilter
{
    @Context
    private ResourceInfo resourceInfo;

    public static final String AUTHENTICATED_USER = "authenticatedUser";

    private static JWTVerifier JWT_VERIFIER = JWT.require(AUTH_ALGORITHM)
                                                 .withIssuer(ISSUER)
                                                 .build();

    public void filter(ContainerRequestContext requestContext)
    {
        Method method = resourceInfo.getResourceMethod();
        if (!requestContext.getMethod().equals(HttpMethod.OPTIONS) && !method.isAnnotationPresent(PermitAll.class))
        {
            final String jwtToken = requestContext.getHeaderString(JWT_HEADER);

            if (jwtToken == null || jwtToken.isEmpty())
            {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                                                 .entity("Provide a valid token for access!").build());
                return;
            }
            DecodedJWT decodedJWT = null;
            try
            {
                decodedJWT = JWT_VERIFIER.verify(jwtToken);

            }
            catch (JWTVerificationException e)
            {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                                                 .entity("Your token has expired, please reauthorize!").build());
            }

            if (decodedJWT != null)
            {
                String userRole = Roles.getNameOfRole(decodedJWT.getClaim(ROLE_CLAIM).asInt());
                String username = decodedJWT.getClaim(USERNAME_CLAIM).asString();
                //Verify user access
                if (method.isAnnotationPresent(RolesAllowed.class))
                {
                    RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                    Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
                    if (!rolesSet.contains(userRole))
                    {
                        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                                                         .entity("You don't have enough rights!").build());
                    }
                    else
                    {
                        requestContext.setProperty(AUTHENTICATED_USER,
                                                   username);
                    }
                }
            }
        }
    }
}
