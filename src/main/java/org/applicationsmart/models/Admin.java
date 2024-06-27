package org.applicationsmart.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Boolean isActive = false;
}
