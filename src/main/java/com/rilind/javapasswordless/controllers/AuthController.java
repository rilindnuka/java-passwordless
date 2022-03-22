package com.rilind.javapasswordless.controllers;
import com.rilind.javapasswordless.api.AuthApi;
import com.rilind.javapasswordless.models.*;
import com.rilind.javapasswordless.repositories.PasswordUserRepository;
import com.rilind.javapasswordless.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthController implements AuthApi {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private AuthService service;

    public AuthController(AuthService service){
        this.service=service;
    }

    @Override
    public ResponseEntity<AuthResponseDto> authenticate(LoginWithCodeDto body) {
        LOG.info("Authenticating with code: "+body.toString());
        return ResponseEntity.ok(new AuthResponseDto());
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
        service.loginAttempt(body);
        return ResponseEntity.ok(body);
    }
}
