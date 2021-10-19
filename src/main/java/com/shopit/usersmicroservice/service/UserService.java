package com.shopit.usersmicroservice.service;

import java.util.List;

import com.shopit.usersmicroservice.entity.User;
import com.shopit.usersmicroservice.model.UserTO;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUserByID(long id);
	User updateUser(User user, long id);
	void deleteUserById(long id);
	UserTO getUserByAccountId(long id);
}