package org.applicationsmart.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.applicationsmart.models.Roles;

@Getter
@Setter
public class UserRegistrationRequest {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private Roles roles;


    private VendorRegistrationRequest vendorRegistrationRequest;
    private CustomerRegistrationRequest customerRegistrationRequest;
    private AdminRegistrationRequest adminRegistrationRequest;
}
