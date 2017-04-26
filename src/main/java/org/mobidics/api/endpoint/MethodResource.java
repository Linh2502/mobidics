package org.mobidics.api.endpoint;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Long Bui on 28.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Path("methods")
public class MethodResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMethods()
    {
        return Response.ok().build();
    }
}
