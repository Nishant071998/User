package com.demo.user.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.entity.User;
import com.demo.user.resp.UserResponse;
import com.demo.user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class Controller {
	@Autowired
	UserService userService;
	@PostMapping(value="/login")
	public UserResponse login(@RequestBody User user)
	{   boolean response=false;
	    User userResp =userService.login(user.getUserEmail(),user.getUserPassword());
		UserResponse response2= new UserResponse();
		if(userResp!=null)
		{
			response=true;
		}
		response2.setResponse(response);
		response2.setUser(userResp);
			return response2;
		
		
	}

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{   
		long lowerLimit = 123456712L;
		long upperLimit = 234567892L;
		Random r = new Random();
		long number = lowerLimit+((long)(r.nextDouble()*(upperLimit-lowerLimit)));
		user.setId(number);
	    String response = userService.addUser(user);
		
		return response;
	}
}

