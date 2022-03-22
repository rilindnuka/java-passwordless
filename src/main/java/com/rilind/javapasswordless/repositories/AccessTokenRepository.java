package com.rilind.javapasswordless.repositories;

import com.rilind.javapasswordless.models.auth.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
    Optional<AccessToken> findByUser_Id(String userId);
    Optional<AccessToken> findByAccessToken(String accessToken);
}
