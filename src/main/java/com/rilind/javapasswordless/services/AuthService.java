package com.rilind.javapasswordless.services;

import com.rilind.javapasswordless.models.LoginAttemptDto;

public interface AuthService {
    void loginAttempt(LoginAttemptDto attemptDto);
    String loginWithCodeAndEmail(String email, String code);
    String checkHealth(String accessKey);
}
