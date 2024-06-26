package org.applicationsmart.models;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter

public class OrderItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String type;
    private String description;
    private String productNumber;
    private String customerId;


}
