package com.blog.blogappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogappapi.payloads.UserDto;
import com.blog.blogappapi.security.AuthenticationRequest;
import com.blog.blogappapi.security.AuthenticationService;
import com.blog.blogappapi.security.JwtAuthResponse;
import com.blog.blogappapi.security.RegisterRequest;
import com.blog.blogappapi.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private AuthenticationService service;
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
		@RequestBody AuthenticationRequest request
	) throws Exception{
		return ResponseEntity.ok(service.authneticate(request));
	}
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(
		@RequestBody UserDto userDto
	){
		UserDto registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);
	}
}
