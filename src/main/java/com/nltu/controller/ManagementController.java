package com.nltu.controller;

import com.nltu.entity.Country;
import com.nltu.entity.Hotel;
import com.nltu.entity.Room;
import com.nltu.service.CountryService;
import com.nltu.service.HotelService;
import com.nltu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String showManagementPage(Model model) {
        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("hotels", hotelService.getHotels());

        model.addAttribute("rooms", roomService.getRooms());
        return "management";
    }

}
