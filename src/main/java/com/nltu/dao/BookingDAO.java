package com.nltu.dao;

import java.util.List;

import com.nltu.entity.Booking;

public interface BookingDAO {
	public List<Booking> getAllBookings();

	public void saveBooking(Booking booking);

	List<Booking> getBookingsByUserId(int userId);

	public List<Booking> getAvailableBookings();
}
