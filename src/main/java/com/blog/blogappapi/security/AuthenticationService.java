package com.blog.blogappapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.blogappapi.entity.User;
import com.blog.blogappapi.exceptions.ApiException;
import com.blog.blogappapi.repository.UserRepository;


@Service
public class AuthenticationService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenHelper jwtTokenHelper;
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	
	public JwtAuthResponse register(RegisterRequest request) {
//		var user= User.builder()
//					.name(request.getName())
//					.email(request.getEmail())
//					.password(passwordEncoder.encode(request.getPassword()))
//					.build();
//			userRepository.save(user);
//		var jwtToken = jwtTokenHelper.generateToken(user);
//		return JwtAuthResponse.builder()
//										.token(jwtToken)
//										.build();
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		String jwtToken = jwtTokenHelper.generateToken(user);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(jwtToken);					
		return response;
	}
	public JwtAuthResponse authneticate(AuthenticationRequest request) throws Exception{
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
			);
		} catch (BadCredentialsException e) {
			throw new ApiException("Invalid username or password");
		}
		UserDetails userDetails= this.userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return response;

	}

}
