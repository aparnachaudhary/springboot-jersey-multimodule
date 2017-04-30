package io.github.aparnachaudhary.resources;

import io.github.aparnachaudhary.exceptions.GenericExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by aparna on 4/25/17.
 */
@Component
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(CustomerResource.class);
        register(GenericExceptionMapper.class);
    }
}
