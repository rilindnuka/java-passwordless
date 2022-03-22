package com.rilind.javapasswordless.services;

import com.rilind.javapasswordless.models.PasswordlessUser;
import com.rilind.javapasswordless.repositories.PasswordLessUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private PasswordLessUserRepository repository;

    public UserService(PasswordLessUserRepository repository){
        this.repository=repository;
    }

    public PasswordlessUser getUserByEmail(String email){
        Optional<PasswordlessUser> optionalUser = repository.findByEmail(email);
        return optionalUser.isPresent()? optionalUser.get():null;
    }
    public PasswordlessUser saveUser(String email){
        PasswordlessUser user = getUserByEmail(email);
        if( user == null){
            user = new PasswordlessUser();
            user.setEmail(email);
            return repository.save(user);
        }else {
            return user;
        }
    }

    public PasswordlessUser getUserById(String id){
        Optional<PasswordlessUser> optionalUser = repository.findById(id);
        return optionalUser.isPresent()? optionalUser.get():null;
    }
}
