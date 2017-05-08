package org.mobidics.api.resource;


import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;
import java.util.Set;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Path("/users")
public class UserResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ResourceContext resourceContext;

    @Context
    ContainerRequestContext requestContext;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}/favorites")
    public Response getFavoritesOfUser(@PathParam("username") String username)
    {
        User loadedUser = new UserDAO().getUserByUsername(username);
        Set<String> favorites = loadedUser.getFavorites();
        return Response.ok(favorites).build();
    }
}
