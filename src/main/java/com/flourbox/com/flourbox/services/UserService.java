package com.flourbox.com.flourbox.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flourbox.com.flourbox.model.User;

@Service
public interface UserService {

	public User registorUser(User user);
	
	public User getUser(Long userId);
	
	public List<User> getAllUser();
	
	public void deleteUser(Long id);
	
	
}
