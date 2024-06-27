package org.applicationsmart.services;

import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.UserRegistrationRequest;
import org.applicationsmart.dtos.response.LoginResponse;
import org.applicationsmart.dtos.response.UserRegistrationResponse;
import org.applicationsmart.exception.UserNotFoundException;
import org.applicationsmart.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest);
    LoginResponse login(LoginRequest loginRequest) throws UserNotFoundException;

    User findById(Long id) ;

}
