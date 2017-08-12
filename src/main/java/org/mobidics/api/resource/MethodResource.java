package org.mobidics.api.resource;

import com.owlike.genson.Genson;
import org.mobidics.api.filter.auth.Roles;
import org.mobidics.api.viewmodel.MethodReducedViewModel;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.CommentDAO;
import org.mobidics.data.MethodDAO;
import org.mobidics.data.RatingDAO;
import org.mobidics.model.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.*;

import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.USERLEVEL;
import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.USERNAME;

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
    public Response getAllMethods(@QueryParam("search") String searchString,
                                  @QueryParam("phase") List<String> phases,
                                  @QueryParam("subphase") List<String> subphases,
                                  @QueryParam("coursetype") List<String> coursetypes,
                                  @QueryParam("grouptype") int groupType,
                                  @QueryParam("groupmax") int maxGroupSize,
                                  @QueryParam("maxtime") int maxTime,
                                  @QueryParam("minrating") int minRating,
                                  @QueryParam("socialform") List<String> socialforms)
    {
        System.out.println(socialforms);
        MethodDAO methodDAO = new MethodDAO();
        List<MethodGerman> methodsRaw = methodDAO.getMethodsWithFilters(searchString,
                                                                        phases,
                                                                        subphases,
                                                                        coursetypes,
                                                                        groupType,
                                                                        maxGroupSize,
                                                                        maxTime,
                                                                        minRating,
                                                                        socialforms);
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
    @Path("/favoriteIds")
    public Response getFavoriteIds()
    {
        Set<String> favorites = new MethodDAO()
                .getFavoriteIdsOfUsername((String) requestContext.getProperty(
                        USERNAME));
        return Response.ok(favorites).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/favorites")
    public Response getFavorites()
    {
        MethodDAO methodDAO = new MethodDAO();
        List<MobiDicsMethod> favorites = methodDAO.getFavoritesOfUsername((String) requestContext.getProperty(
                USERNAME));
        List<MethodReducedViewModel> favoritesReduced = new ArrayList<>();
        favorites.forEach((MobiDicsMethod method) ->
                                  favoritesReduced.add(new MethodReducedViewModel(method)));
        return Response.ok(favoritesReduced).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @PUT
    @Path("/favorites/{id}")
    public Response addFavorite(@PathParam("id") String id)
    {
        MethodDAO methodDAO = new MethodDAO();
        boolean added = methodDAO.addFavorite((String) requestContext.getProperty(USERNAME), id);
        return Response.ok(added).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @DELETE
    @Path("/favorites/{id}")
    public Response deleteFavorite(@PathParam("id") String id)
    {
        MethodDAO methodDAO = new MethodDAO();
        boolean removed = methodDAO.deleteFavorite((String) requestContext.getProperty(USERNAME), id);
        return Response.ok(removed).build();
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
    @Path("/{id}")
    public Response deleteMethod(@PathParam("id") String id)
    {
        MethodDAO methodDAO = new MethodDAO();
        boolean deleted = methodDAO.deleteMethodById(id);
        return Response.ok(deleted).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Path("/{id}/comments")
    public Response getMethodComments(@PathParam("id") String id)
    {
        CommentDAO commentDAO = new CommentDAO();
        List<Comment> result = commentDAO.getCommentsOfMethodWithId(id);
        return Response.ok(result).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @POST
    @Path("/{id}/comments")
    public Response addMethodComment(@PathParam("id") String id, Comment postedComment)
    {
        CommentDAO commentDAO = new CommentDAO();
        boolean result = commentDAO.addComment(id,
                                               (String) requestContext.getProperty(USERNAME),
                                               postedComment);
        return Response.ok(result).build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @DELETE
    @Path("/{methodId}/comments/{commentId}")
    public Response deleteMethodComment(@PathParam("methodId") String methodId,
                                        @PathParam("commentId") String commentId)
    {
        CommentDAO commentDAO = new CommentDAO();
        Comment comment = commentDAO.getCommentById(commentId);
        if (requestContext.getProperty(USERLEVEL).equals(Roles.ADMIN) || requestContext.getProperty(USERNAME)
                                                                                       .equals(comment.getUsername()))
        {
            boolean result = commentDAO.deleteComment(commentId);
            return Response.ok(result).build();

        }
        else
        {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @PUT
    @Path("/{methodId}/rating/{rating}")
    public Response rateMethod(@PathParam("methodId") String methodId,
                               @PathParam("rating") int rating)
    {
        RatingDAO ratingDAO = new RatingDAO();
        String username = (String) requestContext.getProperty(USERNAME);
        boolean success = ratingDAO.updateRatingOfUserOnMethodWithId(username, methodId, rating);
        if (success)
        {
            return Response.ok().build();
        }
        else
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Path("/{methodId}/rating/")
    public Response getPersonalRating(@PathParam("methodId") String methodId)
    {
        RatingDAO ratingDAO = new RatingDAO();
        String username = (String) requestContext.getProperty(USERNAME);
        Rating rating = ratingDAO.getRatingOfUserOnMethodWithId(username, methodId);
        if (rating == null)
        {
            rating = new Rating();
        }
        return Response.ok(rating).build();
    }

    @PermitAll
    @GET
    @Path("/mins-maxes")
    public Response getMinMaxes()
    {
        MethodDAO methodDAO = new MethodDAO();
        MinMaxSummary minMaxSummary = methodDAO.getMinMaxes();
        return Response.ok(minMaxSummary).build();
    }
}
