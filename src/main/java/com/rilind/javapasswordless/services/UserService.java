package com.rilind.javapasswordless.services;

import com.rilind.javapasswordless.models.PasswordlessUser;

public interface UserService {
    PasswordlessUser getUserByEmail(String email);
    PasswordlessUser saveUser(String email);
    PasswordlessUser getUserById(String id);
}
