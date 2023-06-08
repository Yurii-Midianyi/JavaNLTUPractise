package com.nltu.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nltu.dao.UserDAO;
import com.nltu.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	private final SessionFactory sessionFactory;
	private final UserDAO userDAO;

	@Autowired
	public UserServiceImpl(SessionFactory sessionFactory, UserDAO userDAO) {
		this.sessionFactory = sessionFactory;
		this.userDAO = userDAO;
	}

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
	public Boolean checkUserExists(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery =
				currentSession.createQuery("from User where username = :username", User.class);
		theQuery.setParameter("username", username);

		List<User> users = theQuery.getResultList();

		return !users.isEmpty();
	}
}
