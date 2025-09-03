package com.openflicker.data;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will automatically implement this method for us
    // based on the method name. It will generate a query to find a User by its username.
    Optional<User> findByUsername(String username);
}
