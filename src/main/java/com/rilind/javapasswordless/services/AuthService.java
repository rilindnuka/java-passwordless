package com.rilind.javapasswordless.services;

import com.rilind.javapasswordless.models.LoginAttemptDto;
import com.rilind.javapasswordless.models.auth.LoginAttempt;
import com.rilind.javapasswordless.repositories.AccessTokenRepository;
import com.rilind.javapasswordless.repositories.LoginAttemptRepository;
import com.rilind.javapasswordless.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private AccessTokenRepository accessTokenRepository;
    private LoginAttemptRepository loginAttemptRepository;
    private Utils utils;

    public AuthService(AccessTokenRepository accessTokenRepository,
                       LoginAttemptRepository loginAttemptRepository,
                       Utils utils){
        this.accessTokenRepository=accessTokenRepository;
        this.loginAttemptRepository=loginAttemptRepository;
        this.utils = utils;
    }

    public void loginAttempt(LoginAttemptDto attemptDto){
        Optional<LoginAttempt> optionalLoginAttempt = loginAttemptRepository.findByEmail(attemptDto.getEmail());
        LoginAttempt loginAttempt;
        if (!optionalLoginAttempt.isPresent()){
            loginAttempt = new LoginAttempt();
            loginAttempt.setCode(utils.genereateFourDigitCode());
            loginAttempt.setEmail(attemptDto.getEmail());
        }else {
            //TODO The logic needs to be extended to a point where a timeout for generating a new code is implemented
            loginAttempt = optionalLoginAttempt.get();
            loginAttempt.setCode(utils.genereateFourDigitCode());
        }
        loginAttemptRepository.save(loginAttempt);
    }




}
