package com.demo.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.entity.User;
import com.demo.user.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public String addUser( User user)
	{
		try {

			userRepo.save(user);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return "Failed";
		}
		return "success";

	}

	public User login(String email, String password) {
		User user = new User();
		try {
		  user = userRepo.findAll().stream().filter(x->x.getUserEmail().equalsIgnoreCase(email)).collect(Collectors.toList()).get(0);
		  if(email.equalsIgnoreCase(user.getUserEmail())&&password.equalsIgnoreCase(user.getUserPassword()))
		  {
			  return user;
		  }
			
		}
		catch (Exception e) {
			return null;
		}
		return null ;
	}
}
