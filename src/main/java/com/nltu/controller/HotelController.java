package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nltu.dao.HotelDAO;
import com.nltu.entity.Hotel;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelDAO hotelDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get hotels from the dao
		List<Hotel> theHotels = hotelDAO.getHotels();
		System.out.println(theHotels);
		
		//add the hotels to the model
		theModel.addAttribute("hotels", theHotels);
		
		return "hotelList";
		
	}
}
