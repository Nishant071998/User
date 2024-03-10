package com.demo.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Double> {

	//User findByEmail(String email);

	
}
