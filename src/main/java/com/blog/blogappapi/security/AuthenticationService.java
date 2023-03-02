package com.blog.blogappapi.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.var;
import com.blog.blogappapi.entity.User;
import com.blog.blogappapi.repository.UserRepository;


@Service
@AllArgsConstructor
public class AuthenticationService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenHelper jwtTokenHelper;
	private AuthenticationManager authenticationManager;
	
	// public JwtAuthResponse register(RegisterRequest request) {
	// 	var user= User.builder()
	// 				.name(request.getName())
	// 				.email(request.getEmail())
	// 				.password(passwordEncoder.encode(request.getPassword()))
	// 				.roles()
	// 				.build();
					
	// }
	public JwtAuthResponse authneticate(AuthenticationRequest request){
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
		);
		var user=userRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken= jwtTokenHelper.generateToken(user);
		return JwtAuthResponse.builder()
										.token(jwtToken)
										.build();
	}
}
