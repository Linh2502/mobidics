package org.mobidics.api.endpoint;


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
    public Response getAllUsers()
    {
        return Response.ok().build();
    }
}
