package org.mobidics.api.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

import static org.mobidics.api.resource.AuthResource.JWT_HEADER;

/**
 * Created by Long Bui on 17.04.16.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class CorsFilter implements ContainerResponseFilter
{
    @Override
    public void filter(final ContainerRequestContext containerRequestContext,
                       final ContainerResponseContext containerResponseContext)
            throws IOException
    {
        containerResponseContext.getHeaders()
                                .add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders()
                                .add("Access-Control-Allow-Headers",
                                     "origin, content-type, accept, authorization, " + JWT_HEADER);
        containerResponseContext.getHeaders()
                                .add("Access-Control-Expose-Headers", JWT_HEADER);
        containerResponseContext.getHeaders()
                                .add("Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders()
                                .add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
