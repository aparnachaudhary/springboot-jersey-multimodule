package io.github.aparnachaudhary.resources;

import io.github.aparnachaudhary.entities.Customer;
import io.github.aparnachaudhary.exceptions.CustomerNotFoundException;
import io.github.aparnachaudhary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Created by aparna on 4/25/17.
 */
@Path("customers")
public class CustomerResource {

    private CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Customer customer, @Context UriInfo uriInfo){
        Customer saved = customerService.create(customer);
        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", saved.getId())
                .build();

        return Response.created(location).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> find(){
        return customerService.list();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer get(@PathParam("id") String id) throws CustomerNotFoundException {
        return customerService.findById(id);
    }
}
