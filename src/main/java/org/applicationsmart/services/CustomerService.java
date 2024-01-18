package org.applicationsmart.services;

import org.applicationsmart.data.repository.CustomerRepository;
import org.applicationsmart.dtos.request.RegisterRequest;


public interface CustomerService {
    void editCustomer();
    void deleteCustomer();
    void searchCustomer();

    void register(RegisterRequest registerRequest);

    void login(RegisterRequest registerRequest);
}
