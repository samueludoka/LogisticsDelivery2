package org.applicationsmart.models;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String address;
    private String Location;
    private boolean isLocked = true;
}