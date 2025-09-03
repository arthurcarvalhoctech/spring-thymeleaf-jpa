package com.openflicker.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Lombok annotation to create getters, setters, toString, etc.
@Entity
@Table(name = "users") // Explicitly name the table to avoid conflicts with SQL keywords like "user"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // Example: "ROLE_USER", "ROLE_ADMIN"

}
