package com.nltu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nltu.dao.UserDAO;
import com.nltu.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	@Transactional
	public User getUsername(String username) {
		return userDAO.getUsername(username);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userDAO.getUsername(s);
		if (user == null)
			throw new UsernameNotFoundException("User not found");
		return new com.nltu.security.UserDetails(user);
	}
}
