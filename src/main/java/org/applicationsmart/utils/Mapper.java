package org.applicationsmart.utils;

import org.applicationsmart.data.models.Customer;
import org.applicationsmart.dtos.request.RegisterRequest;

public class Mapper {
    public static Customer map(RegisterRequest registerRequest){
        Customer newCustomer = new Customer();
        newCustomer.setUsername(registerRequest.getUsername());
        newCustomer.setPassword(registerRequest.getPassword());
        return  newCustomer;
    }
}
