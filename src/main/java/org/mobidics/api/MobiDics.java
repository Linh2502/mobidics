package org.mobidics.api;

import org.mobidics.api.resource.MethodResource;
import org.mobidics.api.resource.UserResource;
import org.mobidics.api.filter.CorsFilter;
import org.mobidics.api.filter.auth.BasicAuthenticationFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Long Bui on 24.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@ApplicationPath("api")
public class MobiDics extends ResourceConfig
{
    public MobiDics()
    {
        this.register(CorsFilter.class)
            .register(UserResource.class)
            .register(MethodResource.class);
    }
}
