package com.nltu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nltu.dao.BookingDAO;
import com.nltu.entity.Booking;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	@Transactional
	public List<Booking> getAllBookings() {		
		return bookingDAO.getAllBookings();
	}

	@Override
	@Transactional
	public void saveBooking(Booking booking) {
		bookingDAO.saveBooking(booking);
	}

	@Override
	@Transactional
	public List<Booking> getBookingsByUserId(int userId) {
		return bookingDAO.getBookingsByUserId(userId);
	}
}
