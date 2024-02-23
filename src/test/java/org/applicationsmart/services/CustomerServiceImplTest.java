package org.applicationsmart.services;

import org.applicationsmart.data.repository.CustomerRepository;
import org.applicationsmart.data.repository.OrderItemRepository;
import org.applicationsmart.dtos.request.ExtendedUserRequest;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.applicationsmart.dtos.request.RegisterRequest;
import org.applicationsmart.exception.InvalidDetailsException;
import org.applicationsmart.exception.UserExistException;
import org.junit.jupiter.api.BeforeEach;
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
    @Autowired
    OrderItemRepository orderItemRepository;

    @BeforeEach
    public void doThisAfterEachTest(){
        customerRepository.deleteAll();
        orderItemRepository.deleteAll();
    }
    @Test
    public void registerCustomer_registerCustomerAgain_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPassword("azubuike119");
        registerRequest.setUsername("azubuike119");
        customerService.register(registerRequest);
        assertThrows(UserExistException.class, ()-> customerService.register(registerRequest));
    }
    @Test
    public void LoginWithWrongPassword_afterRegisteringUser_throwExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azubuike119");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);
        loginRequest.setUsername("azuzu");
        loginRequest.setPassword("password");
        assertThrows(InvalidDetailsException.class, ()-> customerService.login(loginRequest));
    }
    @Test
    public void LoginWithWrongPassword_afterRegisteringUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azubuike119");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);
        loginRequest.setUsername("azubuike119");
        loginRequest.setPassword("azubuike119");
        customerService.login(loginRequest);
        assertEquals(1,customerRepository.count());
    }
    @Test
    public void testThatWhenACustomerPlacesAnOrder_OrderIncreases(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azubuike119");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);
        loginRequest.setUsername("azubuike119");
        loginRequest.setPassword("azubuike119");
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("Soft Drinks");
        orderDetailsRequest.setProductNumber("123gh");
        orderDetailsRequest.setCustomerName("azubuike119");
        customerService.placeOrder(orderDetailsRequest);
        assertEquals(1,orderItemRepository.count());
    }
    @Test
    public void testThatACustomerCAnAddMoreOrder(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azubuike119");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);
        loginRequest.setUsername("azubuike119");
        loginRequest.setPassword("azubuike119");
        customerService.login(loginRequest);
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("Soft Drinks");
        orderDetailsRequest.setProductNumber("123gh");
        orderDetailsRequest.setCustomerName("azubuike119");
        customerService.placeOrder(orderDetailsRequest);
        orderDetailsRequest.setType("clothing");
        orderDetailsRequest.setDescription("wrist watch");
        orderDetailsRequest.setProductNumber("123gh");
        orderDetailsRequest.setCustomerName("azubuike119");
        customerService.placeOrder(orderDetailsRequest);
        assertEquals(2,orderItemRepository.count());
    }
    @Test
    public void testThatARegisteredCustomerCanPlaceOrderForAnotherCustomer(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("azubuike119");
        registerRequest.setPassword("azubuike119");
        customerService.register(registerRequest);
        loginRequest.setUsername("azubuike119");
        loginRequest.setPassword("azubuike119");
        customerService.login(loginRequest);
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("Soft Drinks");
        orderDetailsRequest.setCustomerName("azubuike119");
        customerService.placeOrder(orderDetailsRequest);
        ExtendedUserRequest extendedUserRequest = new ExtendedUserRequest();
        extendedUserRequest.setName("ope");
        extendedUserRequest.setHouseNumber("55 webere rd");
        extendedUserRequest.setCity("sabo yaba");
        extendedUserRequest.setState("Lagos");
        extendedUserRequest.setCountry("Nigeria");
        customerService.placeOrderForAFriend(orderDetailsRequest);
        assertEquals(2, orderItemRepository.count());
    }
}