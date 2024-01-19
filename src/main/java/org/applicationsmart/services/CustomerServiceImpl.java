package org.applicationsmart.services;

import org.applicationsmart.data.models.Customer;
import org.applicationsmart.data.repository.CustomerRepository;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.RegisterRequest;
import org.applicationsmart.exception.InvalidDetailsException;
import org.applicationsmart.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.applicationsmart.utils.Mapper.map;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    LoginRequest loginRequest;
    @Override
    public void editCustomer() {

    }


    @Override
    public void deleteCustomer() {

    }

    @Override
    public void searchCustomer() {

    }

    @Override
    public void register(RegisterRequest registerRequest) {
        if(userExist(registerRequest.getUsername())) throw new UserExistException(registerRequest.getUsername()+ "already exist");
        Customer customer = map(registerRequest);
        customerRepository.save(customer);
    }


    private boolean userExist(String username) {
        Customer foundCustomer = customerRepository.findCustomerByUsername(username);
        return foundCustomer != null;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        Customer foundCustomer = customerRepository.findCustomerByUsername(loginRequest.getUsername());
        if(!userExist(loginRequest.getUsername())) throw new InvalidDetailsException();
        if(!foundCustomer.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException();
        foundCustomer.setLocked(false);
        customerRepository.save(foundCustomer);
    }
}
