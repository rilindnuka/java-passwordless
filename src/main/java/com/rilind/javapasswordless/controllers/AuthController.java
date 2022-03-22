package com.rilind.javapasswordless.controllers;
import com.rilind.javapasswordless.api.AuthApi;
import com.rilind.javapasswordless.models.AuthResponseDto;
import com.rilind.javapasswordless.models.HealthCheckResponseDto;
import com.rilind.javapasswordless.models.LoginAttemptDto;
import com.rilind.javapasswordless.models.LoginWithCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthController implements AuthApi {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Override
    public ResponseEntity<AuthResponseDto> authenticate(LoginWithCodeDto body) {
        LOG.info("Authenticating with code: "+body.toString());
        return null;
    }

    @Override
    public ResponseEntity<HealthCheckResponseDto> checkHealth(UUID xAuthenticationKey) {
        String key = xAuthenticationKey.toString().toUpperCase();
        LOG.info(String.format("Checking authentication with key: %s", key));
        return null;
    }

    @Override
    public ResponseEntity<LoginAttemptDto> loginWithEmail(LoginAttemptDto body) {
        LOG.info(String.format("Login attempt with email: %s", body.getEmail()));
        return null;
    }
}
