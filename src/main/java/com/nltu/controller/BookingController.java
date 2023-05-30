package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nltu.entity.Booking;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import com.nltu.service.BookingService;

import jakarta.transaction.Transactional;


@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	@Transactional
	public String getAllBookings(Model model) {	
		List<Booking> bookings = bookingService.getAllBookings();	
		bookings.toString(); //resolve issue with Lazy loading
		model.addAttribute("bookings", bookings);
		return "bookingList";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {		
		Booking booking = new Booking();
		model.addAttribute(booking);
		return "booking-form";
	}
	
	@PostMapping("/saveBooking")
	public String saveRoom(@ModelAttribute("booking") Booking booking) {
		
		bookingService.saveBooking(booking);
		return "redirect:/booking/list";
	}
	
}
