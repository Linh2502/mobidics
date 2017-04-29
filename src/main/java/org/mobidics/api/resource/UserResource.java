package org.mobidics.api.resource;


import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Path("users")
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
    @Path("{username}")
    public Response getUserByUsername(@PathParam("username") String username)
    {
        User loadedUser = new UserDAO().getUserByUsername(username);
        return Response.ok(loadedUser).build();
    }
}
