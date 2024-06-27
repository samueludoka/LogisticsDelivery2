package org.applicationsmart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


import javax.lang.model.element.Name;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private Roles roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
