package org.applicationsmart.data.repository;

import org.applicationsmart.data.models.Customer;
import org.applicationsmart.dtos.request.RegisterRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String > {
    Customer findCustomerByUsername(String username);

}
