package org.mobidics.api.resource;

import org.mobidics.api.viewmodel.MethodReducedViewModel;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.MethodDAO;
import org.mobidics.model.MethodsDeEntity;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;

/**
 * Created by Long Bui on 28.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Path("/methods")
public class MethodResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMethods(@QueryParam("name") @DefaultValue("") String methodName)
    {
        MethodDAO methodDAO = new MethodDAO();
        List<MethodsDeEntity> methodsRaw = methodDAO.getAllMethodsByName(methodName);
        List<MethodReducedViewModel> methods = new LinkedList<>();
        for (MethodsDeEntity methodRaw : methodsRaw)
        {
            methods.add(new MethodReducedViewModel(methodRaw));
        }
        return Response.ok(methods).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getMethodById(@PathParam("id") String methodId)
    {
        MethodDAO methodDAO = new MethodDAO();
        MethodsDeEntity result = methodDAO.getMethodById(methodId);
        if (result == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new MethodViewModel(result)).build();
    }
}
