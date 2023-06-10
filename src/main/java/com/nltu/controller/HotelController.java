package com.nltu.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.nltu.DTO.HotelDTO;
import com.nltu.entity.Booking;
import com.nltu.entity.Country;
import com.nltu.service.BookingService;
import com.nltu.service.CountryService;
import com.nltu.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;

import jakarta.transaction.Transactional;

import javax.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	private final HotelService hotelService;
	private final CountryService countryService;
	private final BookingService bookingService;
	
	@Autowired
	public HotelController(HotelService hotelService, CountryService countryService, BookingService bookingService) {
		this.hotelService = hotelService;
		this.countryService = countryService;
		this.bookingService = bookingService;
	}

	@GetMapping("/list")
	@Transactional
	public String listCustomers(Model model) {
		List<Hotel> theHotels = hotelService.getHotels();
		
		//resolve issue with Lazy loading
		theHotels.toString();
		//add the hotels to the model
		model.addAttribute("hotels", theHotels);

		return "hotels/hotelList";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model){
		model.addAttribute("hotel", hotelService.show(id));
        return "hotels/show";
	}

	@GetMapping("/new")
	public String newHotel(Model model, @ModelAttribute("country") Country country){
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("country", new Country());
		model.addAttribute("countries", countryService.getCountries());
		return "/hotels/new";
	}
	@PostMapping("/list")
	public String create(Model model, @Valid @ModelAttribute("hotel") Hotel hotel,
						 BindingResult bindingResult){
		if (hotelService.checkHotelExists(hotel.getHotelName(), hotel.getCountry().getId()))
			bindingResult.rejectValue("hotelName", "error.hotelName",
					"This hotel is already exists");

		if(bindingResult.hasErrors()) {
			model.addAttribute("countries", countryService.getCountries());
			return "hotels/new";
		}
		else {
			hotelService.save(hotel);
			return "redirect:/hotel/list";
		}
	}

	@GetMapping("/{id}/edit")
	public String edit (Model model , @PathVariable("id") int id){
		model.addAttribute("hotel", hotelService.show(id));
		return "hotels/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("hotel") Hotel hotel,
						 @PathVariable("id") int id){
		hotelService.update(id, hotel);
		return "redirect:/hotel/list";
	}

	@DeleteMapping("/{id}")
	public String delete (@PathVariable("id") int id){
		hotelService.delete(id);
		return "redirect:/hotel/list";
	}

	@PostMapping("/{id}")
	public String showAllRoomsForPeriod(@PathVariable("id") int id, 
										@RequestParam("bSince") String bSince,
										@RequestParam("bTo") String bTo,
										@RequestParam("hotelName") String hotelName,
	                                    @RequestParam("hotelId") int hotelId,
										Model model){
		
		//to fix issue with disappearing hotel.id 
		model.addAttribute("hotel", new HotelDTO(hotelId, hotelName)); 
		
		if (bSince.isEmpty() || bTo.isEmpty()) {
			model.addAttribute("errorMessage", "Please select both start and end dates.");		
			return "hotels/show";
		}
		
		LocalDate bookedSince = LocalDate.parse(bSince);
		LocalDate bookedTo = LocalDate.parse(bTo);
		List<Room> rooms = bookingService.getAllAvailableBookingForPeriod(id, bookedSince, bookedTo);
		model.addAttribute("rooms", rooms);
        return "hotels/show";
	}
	
}
