package org.mobidics.api.property.auth;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 * Created by Long Bui on 01.03.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Provider
public class BasicAuthenticationFilter implements ContainerRequestFilter
{
    @Context
    private ResourceInfo resourceInfo;

    public static final String AUTHENTICATED_USER = "authenticatedUser";
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";

    public void filter(ContainerRequestContext requestContext)
    {
//        Method method = resourceInfo.getResourceMethod();
//        //Access allowed for all
//        if (!method.isAnnotationPresent(PermitAll.class))
//        {
//            //Access denied for all
//            if (method.isAnnotationPresent(DenyAll.class))
//            {
//                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
//                                                 .entity("Access blocked for all users !!").build());
//                return;
//            }
//
//            final String authorization = requestContext.getHeaderString(AUTHORIZATION_PROPERTY);
//
//            //If no authorization information present; block access
//            if (authorization == null || authorization.isEmpty())
//            {
//                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
//                                                 .entity("You cannot access this model").build());
//                return;
//            }
//
//            //Get encoded username and password
//            final String encodedUserPassword = authorization.replaceFirst(AUTHENTICATION_SCHEME + " ", "");
//
//            //Decode username and password
//            String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
//
//            //Split username and password tokens
//            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
//            final String username = tokenizer.nextToken();
//            final String password = tokenizer.nextToken();
//
//            //Verify user access
//            if (method.isAnnotationPresent(RolesAllowed.class))
//            {
//                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
//                Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
//
//                //Is user valid?
//                if (!isUserAllowed(username, password, rolesSet))
//                {
//                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
//                                                     .entity("You cannot access this model").build());
//                }
//                else
//                {
////                    requestContext.setProperty(AUTHENTICATED_USER,
////                                               IMObjectDBDAO.getInstance().getUserByUsername(username));
//                }
//            }
//        }
    }

//    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet)
//    {
//        boolean isAllowed = false;
//        User requestedUser = IMObjectDBDAO.getInstance().getUserByUsername(username);
//        if (requestedUser != null)
//        {
//            AuthenticationVO authenticationVO = requestedUser.getAuthInfo();
//
//            if (authenticationVO.getPassword().equals(password))
//            {
//                if (rolesSet.contains(requestedUser.getRole()))
//                {
//                    isAllowed = true;
//                }
//            }
//        }
//        return isAllowed;
//    }
}
