package org.mobidics.api.resource;

import org.mobidics.api.filter.auth.Roles;
import org.mobidics.data.CommentDAO;
import org.mobidics.model.Comment;
import org.mobidics.model.CommentVote;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.USERLEVEL;
import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.USERNAME;

@Path("/comments")
public class CommentResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @DELETE
    @Path("/{commentId}")
    public Response deleteMethodComment(@PathParam("commentId") String commentId)
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
    @POST
    @Path("/{commentId}/votes")
    public Response updateCommentVotes(@PathParam("commentId") String commentId, CommentVote commentVote)
    {
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.addCommentVote(new CommentVote((String) requestContext.getProperty(USERNAME),
                                                  commentId,
                                                  commentVote.getValue()));
        return Response.ok().build();
    }
}
