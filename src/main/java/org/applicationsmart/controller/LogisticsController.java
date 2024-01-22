package org.applicationsmart.controller;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.OrderItemDetailsRequest;
import org.applicationsmart.dtos.response.ApiResponse;
import org.applicationsmart.dtos.response.LoginResponse;
import org.applicationsmart.dtos.response.OrderResponse;
import org.applicationsmart.dtos.response.RegisterResponse;

import org.applicationsmart.dtos.request.RegisterRequest;
import org.applicationsmart.exception.LogisticsDeliveryException;
import org.applicationsmart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticsController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        try{
            customerService.register(registerRequest);
            registerResponse.setMessage("Account created successfully");
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.CREATED);
        }
        catch (LogisticsDeliveryException ex){
            registerResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, registerResponse), HttpStatus.BAD_REQUEST);

        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();

        try{
            customerService.login(loginRequest);
            loginResponse.setMessage("login successfully");
            return new ResponseEntity<>(new ApiResponse(true, loginResponse), HttpStatus.CREATED);
        }
        catch (LogisticsDeliveryException ex){
            loginResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, loginResponse), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/placeAnOrder")
    public ResponseEntity<?> PlaceAnOrder(@RequestBody OrderItemDetailsRequest orderItemDetailsRequest) {
        OrderResponse orderResponse = new OrderResponse();
        try {
            customerService.placeOrder(orderItemDetailsRequest);
            orderResponse.setMessage("order placed successfully");
            return new ResponseEntity<>(new ApiResponse(true, orderResponse), HttpStatus.CREATED);
        } catch (LogisticsDeliveryException ex) {
            orderResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, orderResponse), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/placeOrderForAFriend")
    public ResponseEntity<?> PlaceOrderForAFriend(@RequestBody OrderItemDetailsRequest orderItemDetailsRequest) {
        OrderResponse orderResponse = new OrderResponse();

        try {
            customerService.placeOrder(orderItemDetailsRequest);
            orderResponse.setMessage("friend's order placed successfully");
            return new ResponseEntity<>(new ApiResponse(true, orderResponse), HttpStatus.CREATED);
        } catch (LogisticsDeliveryException ex) {
            orderResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, orderResponse), HttpStatus.BAD_REQUEST);
        }
    }

}
