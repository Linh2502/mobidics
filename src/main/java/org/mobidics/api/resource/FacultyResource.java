package org.mobidics.api.resource;

import org.mobidics.api.filter.auth.Roles;
import org.mobidics.data.FacultyDAO;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/faculties")
public class FacultyResource
{
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFaculties()
    {
        FacultyDAO facultyDAO = new FacultyDAO();
        return Response.ok(facultyDAO.getAllFaculties()).build();
    }
}
