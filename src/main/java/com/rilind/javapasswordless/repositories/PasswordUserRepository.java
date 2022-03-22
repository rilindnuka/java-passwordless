package com.rilind.javapasswordless.repositories;

import com.rilind.javapasswordless.models.PasswordlessUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordUserRepository extends JpaRepository<PasswordlessUser, String> {
}
