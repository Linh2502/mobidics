package org.mobidics.api.resource;


import org.mobidics.api.filter.auth.Roles;
import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;
import java.util.Set;

import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.AUTHENTICATED_USER;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: longbui1992@gmail.com
 */
@Path("/users")
public class UserResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response getUserByUsername(@PathParam("username") String username)
    {
        User loadedUser = new UserDAO().getUserByUsername(username);
        if (loadedUser == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(loadedUser).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/me")
    public Response getPersonalProfile()
    {
        User authenticatedUser = new UserDAO()
                .getUserByUsername((String) requestContext.getProperty(AUTHENTICATED_USER));
        return Response.ok(authenticatedUser).build();
    }
}
