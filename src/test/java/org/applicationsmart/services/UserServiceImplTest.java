package org.applicationsmart.services;

import org.applicationsmart.dtos.request.*;
import org.applicationsmart.dtos.response.UserResponse;
import org.applicationsmart.dtos.response.UserRegistrationResponse;
import org.applicationsmart.exception.UserNotFoundException;
import org.applicationsmart.models.Location;
import org.applicationsmart.models.Roles;
import org.applicationsmart.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNotNull;


@SpringBootTest

public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
//    private Role role;

    @Test
    public void testCustomerAsAUserCanRegister(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Udochi");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmail("uka12.u@gmail.com");
        userRegistrationRequest.setPhoneNumber("07033451232");
        userRegistrationRequest.setRoles(Roles.CUSTOMER);
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setCustomerAddress("312 herbert Macaulay way Sabo Yaba");
        customerRegistrationRequest.setCustomerLocation(Location.Yaba);
        userRegistrationRequest.setCustomerRegistrationRequest(customerRegistrationRequest);
        UserRegistrationResponse userRegistrationResponse = userService.register(userRegistrationRequest);
        assertNotNull(userRegistrationResponse);
        assertNotNull(customerRegistrationRequest);
    }

    @Test
    public void testThatVendorAsUserCanRegister(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Udochi");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmail("uka13.u@gmail.com");
        userRegistrationRequest.setPhoneNumber("07033451232");
        userRegistrationRequest.setRoles(Roles.VENDOR);
        VendorRegistrationRequest vendorRegistrationRequest = new VendorRegistrationRequest();
        vendorRegistrationRequest.setLocation(Location.Surulere);
        vendorRegistrationRequest.setCompanyAddress("24 Muyiwa rd, Surulere.");
        vendorRegistrationRequest.setRegNo("01-3456dxz3");
        userRegistrationRequest.setVendorRegistrationRequest(vendorRegistrationRequest);
        UserRegistrationResponse userRegistrationResponse = userService.register(userRegistrationRequest);
        assertNotNull(userRegistrationResponse);
        assertNotNull(vendorRegistrationRequest);
    }

    @Test
    public void testThatUserCanRegisterAsAdmin(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Udochi");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmail("uka18.u@gmail.com");
        userRegistrationRequest.setPhoneNumber("07033451232");
        userRegistrationRequest.setRoles(Roles.ADMIN);
        AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();
        adminRegistrationRequest.setId(1L);
        userRegistrationRequest.setAdminRegistrationRequest(adminRegistrationRequest);

        UserRegistrationResponse userRegistrationResponse = userService.register(userRegistrationRequest);
        assertNotNull(userRegistrationResponse);
        assertNotNull(adminRegistrationRequest);
    }

    @Test
    public void testThatCustomerCanLoginAfterRegistering(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Udochi");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmail("uka21.u@gmail.com");
        userRegistrationRequest.setPhoneNumber("07033451232");
        userRegistrationRequest.setRoles(Roles.CUSTOMER);
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setCustomerAddress("312 herbert Macaulay way Sabo Yaba");
        customerRegistrationRequest.setCustomerLocation(Location.Yaba);
        userRegistrationRequest.setCustomerRegistrationRequest(customerRegistrationRequest);
        userRegistrationRequest.setCustomerRegistrationRequest(customerRegistrationRequest);
        UserRegistrationResponse userRegistrationResponse = userService.register(userRegistrationRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("uka2.u@gmail.com");
        loginRequest.setPassword("password");
        assertNotNull(userRegistrationResponse);
        assertThrows(UserNotFoundException.class, () -> userService.login(loginRequest));
    }

    @Test
    public void getCustomerByEmail(){
        UserResponse userResponse = new UserResponse();
        assertThat(userResponse).isNotNull();
    }
}
