package org.mobidics.api;

import org.mobidics.api.filter.auth.AuthenticationRequestFilter;
import org.mobidics.api.resource.*;
import org.mobidics.api.filter.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: longbui1992@gmail.com
 */
@ApplicationPath("/api")
public class MobiDics extends ResourceConfig
{
    public MobiDics()
    {
        this.register(CorsFilter.class)
            .register(UserResource.class)
            .register(MethodResource.class)
            .register(AuthResource.class)
            .register(UniversityResource.class)
            .register(FacultyResource.class)
            .register(AuthenticationRequestFilter.class);
    }
}
