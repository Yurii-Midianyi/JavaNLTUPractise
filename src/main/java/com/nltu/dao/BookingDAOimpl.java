package com.nltu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nltu.entity.Booking;
import com.nltu.entity.Room;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

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

	@Override
	public void saveBooking(Booking booking) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(booking);		
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Booking> theQuery =
				currentSession.createQuery("from Booking where user.id = " + userId, Booking.class);

		return theQuery.getResultList();
	}

	@Override
	public List<Booking> getAvailableBookings() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Booking> theQuery = 
				currentSession.createQuery("from Booking WHERE enabled = 1", Booking.class);
								
						
		//execute query and get result list
		List<Booking> bookings = theQuery.getResultList();
								
		//return the results
		return bookings;
	}

	@Override
	public void deleteBooking(int bookingId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
//		Query<?> theQuery = currentSession.createQuery("update Booking set enabled = false where id = :bookingId");
//	    theQuery.setParameter("bookingId", bookingId);
//	    theQuery.executeUpdate();	
		
		Booking booking = currentSession.get(Booking.class, bookingId);
		booking.setEnabled(false);	
		currentSession.update(booking);
	}
}
