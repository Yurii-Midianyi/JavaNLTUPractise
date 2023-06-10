package com.nltu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nltu.dao.BookingDAO;
import com.nltu.entity.Booking;
import com.nltu.entity.Room;
import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Booking> getAllBookings() {		
		return bookingDAO.getAllBookings();
	}

	@Override
	@Transactional
	public void saveBooking(Booking booking) {
		if(checkIfBookingIsAvailable(booking.getRoom().getId(), 
				  					 booking.getBookedSince(), 
				  					 booking.getBookedTo())) 
		{
			bookingDAO.saveBooking(booking);	
		}	
	}

	@Override
	@Transactional
	public List<Booking> getBookingsByUserId(int userId) {
		return bookingDAO.getBookingsByUserId(userId);
	}

	@Override
	public List<Booking> getAvailableBookings() {
		return bookingDAO.getAvailableBookings();
	}

	@Override
	@Transactional
	public void deleteBooking(int bookingId) {	
		bookingDAO.deleteBooking(bookingId);
	}

	@Override
	@Transactional
	public Boolean checkIfBookingIsAvailable(int roomId, LocalDate bookedSince, LocalDate bookedTo) {
		
		if(bookedSince == null || bookedTo == null) {
			return false;
		}
		
		if(bookedSince.isAfter(bookedTo)) {
			return false;
		}
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Booking> theQuery =
				currentSession.createQuery("from Booking WHERE enabled=1 AND room.id =:roomId AND (bookedSince BETWEEN "
				+ ":bookedSince AND :bookedTo OR bookedTo BETWEEN :bookedSince AND :bookedTo)" , Booking.class);
		theQuery.setParameter("bookedSince", bookedSince);
		theQuery.setParameter("bookedTo", bookedTo);
		theQuery.setParameter("roomId", roomId);
			
		List<Booking> bookings = theQuery.getResultList();
		return (bookings.isEmpty()) ? true : false;
	}

	@Override
	@Transactional
	public List<Room> getAllAvailableBookingForPeriod(int hotelId, LocalDate bookedSince, LocalDate bookedTo) {
		
		if(bookedSince == null || bookedTo == null) {
			return new ArrayList<Room>();
		}
		
		if(bookedSince.isAfter(bookedTo)) {
			return new ArrayList<Room>();
		}
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Room> theQuery =
				currentSession.createQuery("FROM Room r "
						+ "LEFT JOIN r.bookings b "
						+ "WHERE r.hotel.id = :hotelId "
						+ "AND (b.bookedSince > :bookedTo OR b.bookedTo < :bookedSince OR b.id IS NULL)" , Room.class);
		
		theQuery.setParameter("bookedSince", bookedSince);
		theQuery.setParameter("bookedTo", bookedTo);
		theQuery.setParameter("hotelId", hotelId);
					
		return theQuery.getResultList();
	}
}
/*
 * currentSession.createQuery("SELECT r.id, r.capacity, r.enabled "
						+ "FROM Room r "
						+ "LEFT JOIN r.bookings b "
						+ "WHERE r.hotel.id = :hotelId "
						+ "AND (b.bookedSince > :bookedTo OR b.bookedTo < :bookedSince)" , Room.class);
 */
