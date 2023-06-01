package com.nltu.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nltu.entity.Booking;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import com.nltu.entity.User;
import com.nltu.service.BookingService;
import com.nltu.service.RoomService;
import com.nltu.service.UserService;

import jakarta.transaction.Transactional;


@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	@Transactional
	public String getAllBookings(Model model) {	
		List<Booking> bookings = bookingService.getAllBookings();	
		bookings.toString(); //resolve issue with Lazy loading
		model.addAttribute("bookings", bookings);
		return "bookingList";
	}
	
	
	@PostMapping("/saveBooking")
	//public String saveRoom(@ModelAttribute("booking") Booking booking) {
	public String saveRoom(@RequestParam("bookedSince") String bookedSince,
						   @RequestParam("bookedTo") String bookedTo,
						   @RequestParam("roomId") int roomId) {
		
		
		Room room = roomService.getRoom(roomId);
		User user = userService.getUser(1); //hardcoded user change later
		
			
		Booking booking = new Booking(LocalDate.parse(bookedSince), 
									  LocalDate.parse(bookedTo), 
									  room, user);
		bookingService.saveBooking(booking);
		return "redirect:/booking/list";
	}

	@GetMapping("/list/{userId}")
	@Transactional
	public String showListForUser(@PathVariable int userId, Model model) {
		List<Booking> bookings = bookingService.getBookingsByUserId(userId);
		bookings.toString();
		model.addAttribute("bookings", bookings);
		return "bookingList";
	}
	
}
