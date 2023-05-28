package com.nltu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nltu.entity.Booking;


@Repository
public class BookingDAOimpl implements BookingDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Booking> getAllBookings() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
								
		//create a query
		Query<Booking> theQuery = 
				currentSession.createQuery("from Booking", Booking.class);
								
						
		//execute query and get result list
		List<Booking> bookings = theQuery.getResultList();
								
		//return the results
		return bookings;
	}
	
}
