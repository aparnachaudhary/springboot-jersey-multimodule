package io.github.aparnachaudhary.resources;

import io.github.aparnachaudhary.entities.Customer;
import io.github.aparnachaudhary.exceptions.CustomerNotFoundException;
import io.github.aparnachaudhary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
