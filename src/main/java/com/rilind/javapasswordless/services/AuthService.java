package com.rilind.javapasswordless.services;

import com.rilind.javapasswordless.models.LoginAttemptDto;
import com.rilind.javapasswordless.models.PasswordlessUser;
import com.rilind.javapasswordless.models.auth.AccessToken;
import com.rilind.javapasswordless.models.auth.LoginAttempt;
import com.rilind.javapasswordless.repositories.AccessTokenRepository;
import com.rilind.javapasswordless.repositories.LoginAttemptRepository;
import com.rilind.javapasswordless.repositories.PasswordLessUserRepository;
import com.rilind.javapasswordless.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private AccessTokenRepository accessTokenRepository;
    private LoginAttemptRepository loginAttemptRepository;
    private UserService userService;
    private Utils utils;

    public AuthService(AccessTokenRepository accessTokenRepository,
                       LoginAttemptRepository loginAttemptRepository,
                       UserService userService,
                       Utils utils){
        this.accessTokenRepository=accessTokenRepository;
        this.loginAttemptRepository=loginAttemptRepository;
        this.userService = userService;
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

    public String loginWithCodeAndEmail(String email, String code){
        Optional<LoginAttempt> optionalLoginAttempt = loginAttemptRepository.findByEmail(email);
        if (optionalLoginAttempt.isPresent()){
            LoginAttempt loginAttempt = optionalLoginAttempt.get();
            if (loginAttempt.getCode().equals(code)){
                PasswordlessUser user = userService.getUserByEmail(loginAttempt.getEmail());
                if (user == null){
                    user = userService.saveUser(loginAttempt.getEmail());
                }
                AccessToken accessToken = new AccessToken();
                accessToken.setUser(user);
                accessToken.setAccessToken(utils.generateUUID());
                accessTokenRepository.save(accessToken);
                loginAttemptRepository.delete(loginAttempt);
                return accessToken.getToken();
            }
        }
        return "";
    }

    public String checkHealth(String accessKey){
        Optional<AccessToken> token = accessTokenRepository.findByAccessToken(accessKey);
        if(token.isPresent()){
            AccessToken accessToken = token.get();
            return accessToken.getUser().getEmail();
        }
        return "";
    }




}
