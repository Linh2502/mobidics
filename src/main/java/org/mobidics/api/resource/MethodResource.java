package org.mobidics.api.resource;

import org.mobidics.data.MethodDAO;
import org.mobidics.model.MethodsDeEntity;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        MethodDAO methodDAO = new MethodDAO();
        List<MethodsDeEntity> methods = methodDAO.getAllMethods();
        return Response.ok(methods).build();
    }
}
