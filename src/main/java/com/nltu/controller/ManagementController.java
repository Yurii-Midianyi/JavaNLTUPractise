package com.nltu.controller;
import com.nltu.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/management")
public class ManagementController {

    private final CountryService countryService;
    private final HotelService hotelService;
    private final UserService userService;
    private final BookingService bookingService;


    @Autowired
    public ManagementController(CountryService countryService,
                                HotelService hotelService,
                                UserService userService,
                                BookingService bookingService) {
        this.countryService = countryService;
        this.hotelService = hotelService;
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @GetMapping
    @Transactional
    public String showManagementPage(Model model) {
    	
    	countryService.getCountries().toString(); //resolving issue with LAZY loading
    	userService.getUsers().toString();

        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("hotels", hotelService.getHotels());

        model.addAttribute("users", userService.getUsers());

        model.addAttribute("bookings", bookingService.getAllBookings());

        return "management";
    }

}
