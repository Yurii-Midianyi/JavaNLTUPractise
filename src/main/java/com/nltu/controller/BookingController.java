package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nltu.entity.Booking;
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
		model.addAttribute("bookings", bookings);
		return "bookingList";
	}
	
}
