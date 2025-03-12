package com.flourbox.com.flourbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flourbox.com.flourbox.Exception.UserNotFoundException;
import com.flourbox.com.flourbox.model.User;
import com.flourbox.com.flourbox.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User registorUser(User user) {
		
		User addUser = new User();
		
		addUser.setUserName(user.getUserName());
		addUser.setPhone(user.getPhone());
		addUser.setAddress(user.getAddress());
		addUser.setEmail(user.getEmail());
		addUser.setFullName(user.getFullName());
		addUser.setPassword(user.getPassword());
		
		return userRepository.save(addUser);
		
	}

	@Override
	public User getUser(Long userId) {
		
		User user=null;
		
		boolean userExists = userRepository.findById(userId).isPresent();
		
		if (userExists) {
				
				user=userRepository.findById(userId).get();
			
		}
		else {
		
			userRepository.findById(userId).orElseThrow( () -> {
				throw new UserNotFoundException("User not found");
			});
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser = userRepository.findAll();
		return allUser;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
