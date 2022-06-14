package com.blogpessoal.microservice.loginservice.controller;

import com.blogpessoal.microservice.loginservice.dto.UserRequest;
import com.blogpessoal.microservice.loginservice.security.UserDetailsImpl;
import com.blogpessoal.microservice.loginservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<UserDetailsImpl> login(@RequestBody UserRequest user) {
        return loginService.authentication(user)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }



}
