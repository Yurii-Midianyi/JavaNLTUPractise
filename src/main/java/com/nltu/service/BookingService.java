package com.nltu.service;

import java.time.LocalDate;
import java.util.List;

import com.nltu.entity.Booking;

public interface BookingService {
	public List<Booking> getAllBookings();

	public void saveBooking(Booking booking);

	List<Booking> getBookingsByUserId(int userId);

	public List<Booking> getAvailableBookings();

	public void deleteBooking(int bookingId);
	
	public Boolean checkIfBookingIsAvailable(int roomId, LocalDate bookedSince, LocalDate bookedTo);
}
