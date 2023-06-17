package com.nltu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nltu.entity.Booking;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import com.nltu.security.UserDetails;
import com.nltu.service.HotelService;
import com.nltu.service.RoomService;
import com.nltu.service.UserService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HotelService hotelService; 
	
	@Autowired
	private UserService userService; 
		
	@GetMapping("/list/{hotelId}")
	public String showList(@PathVariable int hotelId, Model model) {
		
		// Retrieve the list of rooms for the specified hotelId
		//List<Room> rooms = roomService.getRooms(hotelId); //get all rooms
		List<Room> rooms = roomService.getAvailableRooms(hotelId); //get all available rooms
		
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
	
		Hotel hotel = hotelService.getHotel(hotelId);

	    // Set the associated Hotel object in the new Room
	    newRoom.setHotel(hotel);
		
		model.addAttribute("room", newRoom);
		
		return "room-form";
	}
	
	@PostMapping("/saveRoom")
	public String saveRoom(@Valid @ModelAttribute("room") Room theRoom,
						   BindingResult bindingResult) {
		
		if(roomService.checkRoomExists(theRoom.getRoomNumber(), theRoom.getHotel().getId())) {
			bindingResult.rejectValue("roomNumber", "error.roomNumber", "This room number already exists");
		}
		
		if(bindingResult.hasErrors()) {
			return "room-form";
		}
		else {
			roomService.saveRoom(theRoom);
			return "redirect:/room/list/"+theRoom.getHotel().getId();
		}
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

	@GetMapping("/book/{roomId}")
	public String bookRoom(@PathVariable int roomId, Model model) {
		int id = -1;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null) {
	    	UserDetails principal = (UserDetails) authentication.getPrincipal();
	        id = principal.getId();
	    }
		
		Booking booking = new Booking();
		booking.setRoom(roomService.getRoom(roomId));
		booking.setUser(userService.getUser(id)); 
		model.addAttribute("booking", booking);	
		return "booking-form";
	}
		
}
