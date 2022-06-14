package com.blogpessoal.microservice.loginservice.service;


import com.blogpessoal.microservice.loginservice.dto.UserRequest;
import com.blogpessoal.microservice.loginservice.dto.UserResponse;
import com.blogpessoal.microservice.loginservice.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {


    private final WebClient webClient;

    public Optional<UserDetailsImpl> authentication(UserRequest userRequest){
        UserResponse userResponse = webClient.get()
                .uri("http://localhost:8081/users/email/{email}", userRequest.getEmail())
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();



        if(Objects.equals(userResponse.getPassword(), userRequest.getPassword() + userRequest.getEmail())){
            Optional<UserDetailsImpl> userDetails = Optional.of(new UserDetailsImpl(userRequest));
            System.out.println("I See you");
            return userDetails;
        }


        return Optional.empty();
    }

}
