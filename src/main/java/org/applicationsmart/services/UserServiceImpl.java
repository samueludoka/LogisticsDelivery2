package org.applicationsmart.services;

import org.applicationsmart.dtos.response.*;
import org.applicationsmart.dtos.request.LoginRequest;
import org.applicationsmart.dtos.request.UserRegistrationRequest;
import org.applicationsmart.exception.UserNotFoundException;
import org.applicationsmart.models.*;
import org.applicationsmart.repository.AdminRepository;
import org.applicationsmart.repository.CustomerRepository;
import org.applicationsmart.repository.UserRepository;
import org.applicationsmart.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdminRepository adminRepository;


    @Override
    public UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest) {
        if (userRepository.existsByEmail(userRegistrationRequest.getEmail())) throw new RuntimeException("email already exist ");
        User newUser = new User();
        newUser.setUsername(userRegistrationRequest.getUserName());
        newUser.setEmail(userRegistrationRequest.getEmail());
        newUser.setPassword(userRegistrationRequest.getPassword());
        newUser.setPhoneNumber(userRegistrationRequest.getPhoneNumber());
        newUser.setRoles(userRegistrationRequest.getRoles());

        User createdUser = userRepository.save(newUser);
        Admin savedAdmin = null;
        Customer savedCustomer = null;
        Vendor savedVendor = null;


        if(Roles.CUSTOMER.equals(userRegistrationRequest.getRoles())){
            Customer customer = new Customer();
            customer.setAddress(userRegistrationRequest.getCustomerRegistrationRequest().getCustomerAddress());
            customer.setLocation(userRegistrationRequest.getCustomerRegistrationRequest().getCustomerLocation());
            savedCustomer = customerRepository.save(customer);
        }else if(Roles.VENDOR.equals(userRegistrationRequest.getRoles())){
            Vendor vendor = new Vendor();
            vendor.setLocation(userRegistrationRequest.getVendorRegistrationRequest().getLocation());
            vendor.setCompanyName(userRegistrationRequest.getVendorRegistrationRequest().getCompanyName());
            vendor.setCompanyAddress(userRegistrationRequest.getVendorRegistrationRequest().getCompanyAddress());
            vendor.setRegNo(userRegistrationRequest.getVendorRegistrationRequest().getRegNo());
            savedVendor = vendorRepository.save(vendor);
        } else if (Roles.ADMIN.equals(userRegistrationRequest.getRoles())) {
            Admin admin = new Admin();
            admin.setId(userRegistrationRequest.getAdminRegistrationRequest().getId());
        }

        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(createdUser.getId());
        response.setUsername(createdUser.getUsername());
        response.setEmail(createdUser.getEmail());
        response.setPassword(createdUser.getPassword());
        response.setPhoneNumber(createdUser.getPhoneNumber());
        response.setRoles(createdUser.getRoles());

        if(Roles.CUSTOMER.equals(createdUser.getRoles()) && savedCustomer != null){
            CustomerRegistrationResponse customerResponse = new CustomerRegistrationResponse();
            customerResponse.setCustomerAddress(savedCustomer.getAddress());
            customerResponse.setCustomerLocation(savedCustomer.getLocation());
            response.setCustomerRegistrationResponse(customerResponse);
        }
        else if(Roles.VENDOR.equals(createdUser.getRoles()) && savedVendor != null){
            VendorRegistrationResponse vendorResponse = new VendorRegistrationResponse();
            vendorResponse.setId(savedVendor.getId());
            vendorResponse.setCompanyAddress(savedVendor.getCompanyAddress());
            vendorResponse.setCompanyName(savedVendor.getCompanyName());
            vendorResponse.setRegNo(savedVendor.getRegNo());
            vendorResponse.setLocation(savedVendor.getLocation());
            response.setVendorRegistrationResponse(vendorResponse);
        } else if (Roles.ADMIN.equals(createdUser.getRoles()) && savedAdmin != null){
            AdminRegistrationResponse adminResponse = new AdminRegistrationResponse();
            adminResponse.setId(savedAdmin.getId());
        }
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws UserNotFoundException {
        User user = getUserEmail(loginRequest.getEmail());
        LoginResponse response;
        if(user != null){
            response = new LoginResponse();
            response.setId(user.getId());
            response.setUserName(user.getUsername());
            response.setPassword(user.getPassword());
            response.setPhoneNumber(user.getPhoneNumber());
            response.setEmail(user.getEmail());
            response.setMessage("Logged in successfully");
        }
        else{
            throw new UserNotFoundException("User with email "+loginRequest.getEmail()+ "does not exist");

        }
        return response;

    }

    @Override
    public User findById(Long id)  {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id" +id+ "does not exist"));
    }

    public User getUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
