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
import com.nltu.entity.Hotel;
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
				currentSession.createQuery("from Booking "
						+ "WHERE enabled=1 "
						+ "AND room.id =:roomId "
						+ "AND ((bookedSince BETWEEN :bookedSince AND :bookedTo) "
						+ "OR (bookedTo BETWEEN :bookedSince AND :bookedTo))" , Booking.class);
		theQuery.setParameter("bookedSince", bookedSince);
		theQuery.setParameter("bookedTo", bookedTo);
		theQuery.setParameter("roomId", roomId);
			
		List<Booking> bookings = theQuery.getResultList();
		System.out.println(bookings);
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
			
		//get all booking that have all rooms in specific hotel
		Query<Booking> bookingQuery = currentSession.createQuery("FROM Booking b " + 
															"LEFT JOIN b.room r " +
															"WHERE r.hotel.id = :hotelId ", Booking.class);
		bookingQuery.setParameter("hotelId", hotelId);
		List<Booking> bookingList = bookingQuery.getResultList();
		
		Hotel hotel = currentSession.get(Hotel.class, hotelId);
		
		//get all rooms from that hotel
		List<Room> allRooms = hotel.getRooms();
		
		List<Room> takenRooms = new ArrayList<>();
		for(Booking b:bookingList) { 
			if(!b.getEnabled() || takenRooms.contains(b.getRoom())) {
				continue;
			}
			//check if bookings overlap our given dates 
			//if yes add room with these bookings to takenRooms
			else if((b.getBookedSince().isBefore(bookedTo) || b.getBookedSince().isEqual(bookedTo)) &&
					(b.getBookedTo().isAfter(bookedSince) || b.getBookedTo().isEqual(bookedSince))) {
				takenRooms.add(b.getRoom());
			}
		}					
		allRooms.removeAll(takenRooms); //remove all taken rooms
		return allRooms;		
	}
}
