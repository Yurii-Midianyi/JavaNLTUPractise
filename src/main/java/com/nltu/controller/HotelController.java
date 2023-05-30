package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.nltu.dao.HotelDAO;
import com.nltu.entity.Hotel;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	private final HotelDAO hotelDAO;
	
	@Autowired
	public HotelController(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}

	@GetMapping("/list")
	@Transactional
	public String listCustomers(Model model) {
		//get hotels from the dao
		List<Hotel> theHotels = hotelDAO.getHotels();
		
		//resolve issue with Lazy loading
		theHotels.toString();
		
		//add the hotels to the model
		model.addAttribute("hotels", theHotels);
		
		return "hotels/hotelList";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model){
		model.addAttribute("hotel", hotelDAO.show(id));
        return "hotels/show";
	}

	@GetMapping("/new")
	public String newHotel(Model model){
		model.addAttribute("hotel", new Hotel());
		return "/hotels/new";
	}
	@PostMapping("/list")
	public String create(@ModelAttribute("hotel") Hotel hotel){
		hotelDAO.save(hotel);
		return "redirect:/hotel/list";
	}

	@GetMapping("/{id}/edit")
	public String edit (Model model , @PathVariable("id") int id){
		model.addAttribute("hotel", hotelDAO.show(id));
		return "hotels/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("hotel") Hotel hotel,
						 @PathVariable("id") int id){
		hotelDAO.update(id, hotel);
		return "redirect:/hotel/list";
	}

	@DeleteMapping("/{id}")
	public String delete (@PathVariable("id") int id){
		hotelDAO.delete(id);
		return "redirect:/hotel/list";
	}

}
