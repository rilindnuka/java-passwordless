package com.rilind.javapasswordless.repositories;

import com.rilind.javapasswordless.models.auth.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, String> {
    Optional<LoginAttempt> findByEmail(String email);
}
