package org.applicationsmart.repository;

import org.applicationsmart.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String > {
    Customer findCustomerByUsername(String username);

}
