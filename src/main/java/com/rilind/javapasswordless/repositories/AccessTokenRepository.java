package com.rilind.javapasswordless.repositories;

import com.rilind.javapasswordless.models.auth.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
}
