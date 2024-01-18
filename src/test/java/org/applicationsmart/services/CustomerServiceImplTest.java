package org.applicationsmart.services;

import org.applicationsmart.data.repository.CustomerRepository;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.applicationsmart.dtos.request.RegisterRequest;
import org.applicationsmart.exception.InvalidDetailsException;
import org.applicationsmart.exception.UserExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        customerRepository.deleteAll();
    }
    @Test
    public void registerCustomer_registerCustomerAgain_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPassword("azubuike119");
        registerRequest.setUsername("azubuike119");
        customerService.register(registerRequest);
        assertThrows(UserExistException.class, () -> customerService.register(registerRequest));
    }
    @Test
    public void LoginWithWrongPassword_afterRegisteringUser_throwExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azuazu");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);

        loginRequest.setUsername("azuzu");
        loginRequest.setPassword("password");
        assertThrows(InvalidDetailsException.class, ()-> customerService.login(registerRequest));
    }
    @Test
    public void testThatWhenACustomerPlacesAnOrder_OrderIncreases(){
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("Soft Drinks");
        orderDetailsRequest.setNumber("2343555");
        orderDetailsRequest.setCustomerId("Customer001");
    }

}