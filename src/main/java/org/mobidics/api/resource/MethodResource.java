package org.mobidics.api.resource;

import com.owlike.genson.Genson;
import org.mobidics.api.filter.auth.Roles;
import org.mobidics.api.viewmodel.MethodReducedViewModel;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.MethodDAO;
import org.mobidics.model.MethodGerman;
import org.mobidics.model.MobiDicsMethod;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;

import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.AUTHENTICATED_USER;

/**
 * Created by Long Bui on 28.02.17.
 * E-Mail: longbui1992@gmail.com
 */
@Path("/methods")
public class MethodResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMethods(@QueryParam("name") @DefaultValue("") String methodName)
    {
        MethodDAO methodDAO = new MethodDAO();
        List<MethodGerman> methodsRaw = methodDAO.getAllMethodsByName(methodName);
        List<MethodReducedViewModel> methods = new LinkedList<>();
        for (MethodGerman methodRaw : methodsRaw)
        {
            methods.add(new MethodReducedViewModel(methodRaw));
        }
        return Response.ok(new Genson().serialize(methods)).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getMethodById(@PathParam("id") String methodId)
    {
        MethodDAO methodDAO = new MethodDAO();
        MobiDicsMethod result = methodDAO.getMethodById(methodId);
        if (result == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Genson().serialize(new MethodViewModel(result))).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/favoritesIds")
    public Response getFavoriteIds()
    {
        Set<String> favorites = new MethodDAO()
                .getFavoriteIdsOfUsername((String) requestContext.getProperty(
                        AUTHENTICATED_USER));
        return Response.ok(favorites).build();
    }

    @RolesAllowed({Roles.USER, Roles.ADMIN})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMethod(MethodViewModel newMethod)
    {
        MethodDAO methodDAO = new MethodDAO();
        boolean added = methodDAO.addMethod(newMethod);
        return Response.ok(added).build();
    }

    @RolesAllowed({Roles.ADMIN})
    @DELETE
    @Path("{id}")
    public Response deleteMethod(@PathParam("id") String id)
    {
        MethodDAO methodDAO = new MethodDAO();
        boolean deleted = methodDAO.deleteMethodById(id);
        return Response.ok(deleted).build();
    }
}
