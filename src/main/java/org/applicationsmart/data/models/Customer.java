package org.applicationsmart.data.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    private String id;
//    private String name;
//    private String number;
//    private String email;
//    private String address;
    private String username;
    private String password;
    private boolean isLocked = true;
}
