package io.github.aparnachaudhary.repository;

import io.github.aparnachaudhary.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aparna on 4/25/17.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{
}
