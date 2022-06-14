package com.blogpessoal.microservice.loginservice.security;

import java.util.Collection;
import java.util.List;

import com.blogpessoal.microservice.loginservice.dto.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl  {

	private String userName;
	private String password;

	

	public UserDetailsImpl(UserRequest userRequest) {
		this.userName = userRequest.getEmail();
		this.password = userRequest.getPassword();
	}

	



}