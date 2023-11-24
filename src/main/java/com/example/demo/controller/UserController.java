package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//    http://localhost:8080/logout

@RestController
public class UserController {

	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser()
	{
		return ResponseEntity.ok("Yes , I'm a normal User");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	 //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser()
	{
		return ResponseEntity.ok("Yes , I'm a Admin");
	}
	
	@PreAuthorize("hasRole('PUBLIC')")
	@GetMapping("/public")
	public ResponseEntity<String> publicUser()
	{
		return ResponseEntity.ok("Yes , I'm a public User");
	}
}
