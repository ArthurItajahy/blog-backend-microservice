package com.blogpessoal.microservice.user.controller;


import com.blogpessoal.microservice.user.model.User;
import com.blogpessoal.microservice.user.repository.UserRepository;
import com.blogpessoal.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity <List<User>> getAll(){
        return  ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getEmail(@PathVariable String email){
        return  userRepository.findByEmail(email)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/register")
    public ResponseEntity<User> postUser(@Valid @RequestBody User user){

        return userService.registerUser(user)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(response))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
