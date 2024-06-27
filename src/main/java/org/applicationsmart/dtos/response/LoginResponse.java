package org.applicationsmart.dtos.response;

import lombok.Data;
import org.applicationsmart.models.Roles;

@Data
public class LoginResponse {
    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private Roles roles;
    private String message;
}
