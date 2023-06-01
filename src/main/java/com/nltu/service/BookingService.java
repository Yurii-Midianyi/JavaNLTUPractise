package com.nltu.service;

import java.util.List;

import com.nltu.entity.Booking;

public interface BookingService {
	public List<Booking> getAllBookings();

	public void saveBooking(Booking booking);

	List<Booking> getBookingsByUserId(int userId);

	public List<Booking> getAvailableBookings();
}
