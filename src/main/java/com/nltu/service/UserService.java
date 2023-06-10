package com.nltu.service;

import java.util.List;

import com.nltu.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUser(int userId);

	void deleteUser(int id);

	Boolean checkUserExists(String username);

	User getUsername(String username);
	void save(User user);

}
