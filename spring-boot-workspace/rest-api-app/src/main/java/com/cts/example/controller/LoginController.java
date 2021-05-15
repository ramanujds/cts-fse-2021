package com.cts.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.dto.Credentials;
import com.cts.example.dto.JwtToken;
import com.cts.example.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class LoginController {
	
	@Autowired
	JwtTokenUtil tokenUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationManager authManager;

	@PostMapping("/public/login")
	public JwtToken generateToken(@RequestBody Credentials cred) {
		System.out.println(cred);
		log.info("Trying Login....");
		authManager.authenticate(new UsernamePasswordAuthenticationToken(cred.getUsername(), cred.getPassword()));
		log.info("Trying to Authenticate....");
		
		UserDetails userDetails=userDetailsService.loadUserByUsername(cred.getUsername());
		System.out.println(userDetails);
		String token=tokenUtil.generateToken(userDetails);
		log.info("Token Generated : " +token );
		return new JwtToken(token);
	}
	
}
