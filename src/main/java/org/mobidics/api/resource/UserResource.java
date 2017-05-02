package org.mobidics.api.resource;


import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.UserDAO;
import org.mobidics.model.MethodsDeEntity;
import org.mobidics.model.User;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;
import java.util.HashSet;
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
        try
        {
            User loadedUser = new UserDAO().getUserByUsername(username);
            return Response.ok(loadedUser).build();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return Response.serverError().build();
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
