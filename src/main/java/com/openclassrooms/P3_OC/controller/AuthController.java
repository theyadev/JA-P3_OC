package com.openclassrooms.P3_OC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.P3_OC.service.AuthService;
import com.openclassrooms.P3_OC.types.JwtRequest;
import com.openclassrooms.P3_OC.types.JwtResponse;
import com.openclassrooms.P3_OC.types.RegisterRequest;
import com.openclassrooms.P3_OC.types.UserResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
	public ResponseEntity<JwtResponse> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		return ResponseEntity.ok(authService.login(authenticationRequest));
	}

	@PostMapping(value = "/register", produces = "application/json", consumes = "application/json")
	public ResponseEntity<JwtResponse> register(@Validated @RequestBody RegisterRequest user) throws Exception {

		return ResponseEntity.ok(authService.register(user));
	}

	@GetMapping("/me")
	public ResponseEntity<UserResponse> me() {
		return ResponseEntity.ok(authService.me());
	}
}
