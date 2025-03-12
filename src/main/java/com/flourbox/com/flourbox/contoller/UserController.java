package com.flourbox.com.flourbox.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flourbox.com.flourbox.model.User;
import com.flourbox.com.flourbox.services.UserService;


@RestController // mark this class as API controller
@RequestMapping("/api")  //base url for this controller

public class UserController {

	@Autowired
	private UserService userService;
	
	// ResponseEntity is used for sending http responce
	@PostMapping("/registor/user")
	public ResponseEntity<User> registorUser(@RequestBody User user){
		
		return new ResponseEntity<>(userService.registorUser(user) ,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/get/all/user")
	public ResponseEntity <List<User>> getAllUser(){
		return new ResponseEntity<>(userService.getAllUser() ,HttpStatus.OK);
	}
	
	@GetMapping("/get/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Long userId) {
	    return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/user")
	public ResponseEntity <Void> removeUser(Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity <> ( HttpStatus.NO_CONTENT);
	}
	
	
}
