package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Users;
import com.security.sevice.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user)
	{
		return userService.register(user);
	}
	
	@PostMapping("/userlogin")
	public String login(@RequestBody Users user)
	{
		System.out.println(user);
		return userService.verify(user);
	}
	

	
	
	
	
}
