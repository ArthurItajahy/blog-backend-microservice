package com.blogpessoal.microservice.user.service;


import com.blogpessoal.microservice.user.model.User;
import com.blogpessoal.microservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> registerUser(User user){

        if(userRepository.findByEmail(user.getEmail()).isPresent())
            return Optional.empty();

        user.setPassword(user.getPassword() + user.getEmail());

        return Optional.of(userRepository.save(user));

    }





}
