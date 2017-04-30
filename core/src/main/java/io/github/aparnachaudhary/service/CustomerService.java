package io.github.aparnachaudhary.service;

import io.github.aparnachaudhary.entities.Customer;
import io.github.aparnachaudhary.exceptions.CustomerNotFoundException;
import io.github.aparnachaudhary.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aparna on 4/25/17.
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer){
      Customer savedCustomer =  customerRepository.save(customer);
        return savedCustomer;
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Customer findById(String id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Not Found for id "+ id);
        }
        return customer;
    }
}
