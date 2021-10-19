package com.shopit.usersmicroservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopit.usersmicroservice.entity.User;
import com.shopit.usersmicroservice.repository.UserRepository;
import com.shopit.usersmicroservice.service.UserService;
import com.shopit.usersmicroservice.model.UserTO;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;
	private UserRepository userRepository;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED); 
	}
	
	@GetMapping ("/all")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping ("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable (value = "id") long userId){
		return new ResponseEntity<User>(userService.getUserByID(userId), HttpStatus.OK);
	}
	
	@PutMapping ("/set/{id}")
	// convert json to java object
	public ResponseEntity<User> updateUser(@PathVariable (value = "id") long userId, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}
	
	@DeleteMapping ("/delete/{id}")
	// convert json to java object
	public ResponseEntity<String> deleteUser(@PathVariable (value = "id") long userId){
		
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}
	
	
	@GetMapping ("/get/account/{accountId}")
	public ResponseEntity<UserTO> getUserByAccountId(@PathVariable (value = "accountId") long accountId){
		return new ResponseEntity<UserTO>(userService.getUserByAccountId(accountId), HttpStatus.OK);
	}
	
}
