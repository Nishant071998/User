package com.demo.user.resp;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

import com.demo.user.entity.User;

public class UserResponse {

	boolean response;
	User user;
	public Boolean getResponse() {
		return response;
	}
	public void setResponse(Boolean response) {
		this.response = response;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserResponse [response=" + response + ", user=" + user + "]";
	}

	
	
}
