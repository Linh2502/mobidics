package org.mobidics.api.resource;


import org.mobidics.api.filter.auth.Roles;
import org.mobidics.api.viewmodel.UserViewModel;
import org.mobidics.data.UserDAO;
import org.mobidics.model.User;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

import static org.mobidics.api.filter.auth.AuthenticationRequestFilter.USERNAME;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: longbui1992@gmail.com
 */
@Path("/users")
public class UserResource
{
    @Context
    UriInfo uriInfo;

    @Context
    ContainerRequestContext requestContext;

    @RolesAllowed({Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers()
    {
        List<User> users = new UserDAO().getAllUsers();
        List<UserViewModel> result = new ArrayList<>();
        users.forEach(user -> result.add(new UserViewModel(user)));
        return Response.ok(result).build();
    }

    @PermitAll
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserViewModel newUser)
    {
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.createUser(newUser);
        if (success)
        {
            return Response.ok().build();
        }
        else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response updateUser(@PathParam("username") String username, UserViewModel user)
    {
        String authenticatedUsername = (String) requestContext.getProperty(USERNAME);
        if (!username.equals(authenticatedUsername))
        {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        UserDAO userDAO = new UserDAO();
        System.out.println((user.getFirstname()));
        userDAO.updateUser(user);
        return Response.ok().build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response getUserByUsername(@PathParam("username") String username)
    {
        User loadedUser = new UserDAO().getUserByUsername(username);
        if (loadedUser == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new UserViewModel(loadedUser)).build();
    }

    @RolesAllowed({Roles.ADMIN})
    @PUT
    @Path("/{username}/approve")
    public Response approveUser(@PathParam("username") String username)
    {
        UserDAO userDAO = new UserDAO();
        userDAO.approveUser(username);
        return Response.ok().build();
    }

    @RolesAllowed({Roles.ADMIN})
    @PUT
    @Path("/{username}/disapprove")
    public Response disapproveUser(@PathParam("username") String username)
    {
        UserDAO userDAO = new UserDAO();
        userDAO.disapproveUser(username);
        return Response.ok().build();
    }

    @RolesAllowed({Roles.ADMIN})
    @DELETE
    @Path("/{username}")
    public Response deleteUser(@PathParam("username") String username)
    {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(username);
        return Response.ok().build();
    }

    @RolesAllowed({Roles.TRIAL, Roles.USER, Roles.ADMIN})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/me")
    public Response getPersonalProfile()
    {
        User authenticatedUser = new UserDAO()
                .getUserByUsername((String) requestContext.getProperty(USERNAME));
        return Response.ok(new UserViewModel(authenticatedUser)).build();
    }

    @RolesAllowed({Roles.ADMIN})
    @PUT
    @Path("{username}/level/{newLevel}")
    public Response updateUserLevel(@PathParam("username") String username, @PathParam("newLevel") int newLevel)
    {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUserLevel(username, newLevel);
        return Response.ok().build();
    }
}
