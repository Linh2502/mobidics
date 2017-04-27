package org.mobidics.api.resource;

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
        List<MethodsDeEntity> methodsRaw = methodDAO.getAllMethods();
        List<MethodViewModel> methods = new LinkedList<>();
        for (MethodsDeEntity methodRaw : methodsRaw)
        {
            methods.add(new MethodViewModel(methodRaw));
        }
        return Response.ok(methods).build();
    }
}
