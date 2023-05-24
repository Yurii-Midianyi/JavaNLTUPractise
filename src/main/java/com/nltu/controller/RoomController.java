package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nltu.dao.RoomDAO;
import com.nltu.entity.Room;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomDAO roomDAO;
		
	@GetMapping("/list/{hotelId}")
	public String showList(@PathVariable int hotelId, Model model) {
		
		// Retrieve the list of rooms for the specified hotelId
		List<Room> rooms = roomDAO.getRooms(hotelId);

		// Add the list of rooms to the model
		model.addAttribute("rooms", rooms);
		model.addAttribute("hotelId", hotelId);
		
		// Return the view name
		return "roomList";
	}
	
	@GetMapping("/showFormForAdd/{hotelId}")
	public String showFormForAdd(@PathVariable int hotelId, Model model) {	
		Room newRoom = new Room();
	
		model.addAttribute("room", newRoom);
		model.addAttribute("hotelId", hotelId);
		
		return "room-form";
	}
}
