package com.blog.blogappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogappapi.security.AuthenticationRequest;
import com.blog.blogappapi.security.AuthenticationService;
import com.blog.blogappapi.security.JwtAuthResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private AuthenticationService service;
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
		@RequestBody AuthenticationRequest request
	){
		return ResponseEntity.ok(service.authneticate(request));
	}
}
