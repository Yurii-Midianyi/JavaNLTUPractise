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

import com.nltu.dao.HotelDAO;
import com.nltu.dao.RoomDAO;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import com.nltu.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HotelDAO hotelDAO; //exchange for service later
		
	@GetMapping("/list/{hotelId}")
	public String showList(@PathVariable int hotelId, Model model) {
		
		// Retrieve the list of rooms for the specified hotelId
		List<Room> rooms = roomService.getRooms(hotelId);

		// Add the list of rooms to the model
		model.addAttribute("rooms", rooms);
		
		// Add the hotelId to the model
		model.addAttribute("hotelId", hotelId);
		
		// Return the view name
		return "roomList";
	}
	
	@GetMapping("/showFormForAdd/{hotelId}")
	public String showFormForAdd(@PathVariable int hotelId, Model model) {	
		Room newRoom = new Room();
	
		Hotel hotel = hotelDAO.getHotel(hotelId);

	    // Set the associated Hotel object in the new Room
	    newRoom.setHotel(hotel);
		
		model.addAttribute("room", newRoom);
		
		return "room-form";
	}
	
	@PostMapping("/saveRoom")
	public String saveRoom(@ModelAttribute("room") Room theRoom) {
		
		roomService.saveRoom(theRoom);
		return "redirect:/room/list/"+theRoom.getHotel().getId();
	}
	
	@GetMapping("/showFormForUpdate/{roomId}")
	public String showFormForUpdate(@PathVariable int roomId, Model model) {	
		Room room = roomService.getRoom(roomId);
		model.addAttribute("room", room);
		return "room-form";
	}
	
	@GetMapping("/delete/{roomId}")
	public String deleteRoom(@PathVariable int roomId, Model model) {	
		
		Room room = roomService.getRoom(roomId);
		int hotelId = room.getHotel().getId(); //to redirect to the right page
		roomService.deleteRoom(roomId);
		
		return "redirect:/room/list/"+hotelId;
	}
}
