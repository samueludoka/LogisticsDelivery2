package org.applicationsmart.services;

import org.applicationsmart.data.repository.CustomerRepository;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.applicationsmart.dtos.request.RegisterRequest;


public interface CustomerService {
    void editCustomer();
    void deleteCustomer();
    void searchCustomer();

    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);
    void placeOrder(OrderItemDetailsRequest orderItemDetailsRequest);

    void placeOrderForAFriend(OrderItemDetailsRequest orderItemDetailsRequest);
}
