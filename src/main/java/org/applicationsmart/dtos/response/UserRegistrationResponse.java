package org.applicationsmart.dtos.response;

import lombok.Data;
import org.applicationsmart.models.Roles;

@Data
public class UserRegistrationResponse {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Roles roles;


    private VendorRegistrationResponse vendorRegistrationResponse;
    private CustomerRegistrationResponse customerRegistrationResponse;
    private AdminRegistrationResponse adminRegistrationResponse;
}
