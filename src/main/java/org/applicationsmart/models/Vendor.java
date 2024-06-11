package org.applicationsmart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Vendor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String businessName;
    private String location;
    private String businessAddress;
    private String RegistrationNumber;
}
