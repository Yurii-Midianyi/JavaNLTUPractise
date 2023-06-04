package com.nltu.dao;

import java.util.List;

import com.nltu.entity.User;

public interface UserDAO {
	public List<User> getUsers();

	public User getUser(int userId);

	void deleteUser(int id);
}
