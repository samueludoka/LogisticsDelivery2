package org.applicationsmart.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}
