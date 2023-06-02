package com.nltu.controller;
import com.nltu.service.CountryService;
import com.nltu.service.HotelService;
import com.nltu.service.RoomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/management")
public class ManagementController {

    public CountryService countryService;
    public HotelService hotelService;
    public RoomService roomService;

    @Autowired
    public ManagementController(CountryService countryService, HotelService hotelService, RoomService roomService) {
        this.countryService = countryService;
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping
    @Transactional
    public String showManagementPage(Model model) {
    	
    	countryService.getCountries().toString(); //resolving issue with LAZY loading
    	
        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("hotels", hotelService.getHotels());

        model.addAttribute("rooms", roomService.getAllRooms());
        return "management";
    }

}
