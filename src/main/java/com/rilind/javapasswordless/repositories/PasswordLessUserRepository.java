package com.rilind.javapasswordless.repositories;

import com.rilind.javapasswordless.models.PasswordlessUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordLessUserRepository extends JpaRepository<PasswordlessUser, String> {
    Optional<PasswordlessUser> findByEmail(String email);
}
