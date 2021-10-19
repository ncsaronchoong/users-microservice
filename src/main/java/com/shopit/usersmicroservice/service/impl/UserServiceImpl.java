package com.shopit.usersmicroservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopit.usersmicroservice.entity.User;
import com.shopit.usersmicroservice.exception.ResourceNotFoundException;
import com.shopit.usersmicroservice.repository.UserRepository;
import com.shopit.usersmicroservice.service.UserService;
import com.shopit.usersmicroservice.model.UserTO;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll(); 
	}

	@Override
	public User getUserByID(long id) {
		User user = userRepository.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}

	}

	@Override
	public User updateUser(User user, long id) {

		User existingUser = userRepository.findByUserId(id);
		if (existingUser != null) {
			existingUser.setUserId(user.getUserId());
			existingUser.setName(user.getName());
			existingUser.setAddress(user.getAddress());
			existingUser.setContactNumber(user.getContactNumber());
			existingUser.setDateOfBirth(user.getDateOfBirth());
			existingUser.setEmail(user.getEmail());
			userRepository.save(existingUser);
			return existingUser;
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}
	}

	@Override
	public void deleteUserById(long id) {
		
		User user = userRepository.findByUserId(id);
		if (user != null) {
			userRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}
		
	}
	
	@Override
	public UserTO getUserByAccountId(long accountId) {
		UserTO userTO = userRepository.findByAccountId(accountId);
		if (userTO != null) {
			return userTO;
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}

	}
	
}
