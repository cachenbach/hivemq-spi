package com.dcsquare.hivemq.spi.services.rest;

import com.dcsquare.hivemq.spi.annotations.Experimental;
import com.dcsquare.hivemq.spi.annotations.ReadOnly;
import com.google.common.base.Preconditions;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Dominik Obermaier
 * @since 2.0
 */
@Experimental
public class RESTConfig {

    private ObjectMapper objectMapper = new ObjectMapper();

    private final List<Class<?>> resources = new ArrayList<Class<?>>();

    private int port = 8080;


    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        Preconditions.checkArgument(port < 65535, "The HTTP REST port must not be higher than 65535. Passed: %s", port);
        Preconditions.checkArgument(port > 1, "The HTTP REST port must not be smaller than 1. Passed: %s", port);
        this.port = port;
    }

    public void addResource(final Class resourceClass) {
        resources.add(resourceClass);
    }

    @ReadOnly
    public Collection<Class<?>> getResources() {
        return Collections.unmodifiableCollection(resources);
    }
}