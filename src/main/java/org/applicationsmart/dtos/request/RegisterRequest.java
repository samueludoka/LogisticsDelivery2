package org.applicationsmart.dtos.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
