package com.nltu.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nltu.entity.Booking;
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
		
		//get all Bookings
		//List<Booking> bookings = bookingService.getAllBookings();	
		
		//get all available Bookings
		List<Booking> bookings = bookingService.getAvailableBookings();	
		bookings.toString(); //resolve issue with Lazy loading
		model.addAttribute("bookings", bookings);
		return "bookingList";
	}
	
	@PostMapping("/saveBooking")	
	public String booking(@Valid @ModelAttribute("booking") Booking booking,
			   BindingResult bindingResult) {
		
		if(!bookingService.checkIfBookingIsAvailable(booking.getRoom().getId(), 
				booking.getBookedSince(), 
				booking.getBookedTo())) {
			bindingResult.rejectValue("bookedSince", "error.bookedSince", "This date in unavailable");
		}
		
		if(bindingResult.hasErrors()) {
			return "booking-form";
		}
		
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
	
	@GetMapping("/delete/{bookingId}") 
	public String deleteBooking(@PathVariable int bookingId, Model model) {	
		bookingService.deleteBooking(bookingId);
		return "redirect:/booking/list";
	}
}
