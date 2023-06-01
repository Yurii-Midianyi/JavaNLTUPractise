package com.nltu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nltu.entity.User;

@Repository
public class UserDAOimpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//create a query
		Query<User> theQuery = 
				currentSession.createQuery("from User", User.class);
						
				
		//execute query and get result list
		List<User> users = theQuery.getResultList();
						
		//return the results
		return users;
	}

	@Override
	public User getUser(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, userId);
		return user;
	}
}
