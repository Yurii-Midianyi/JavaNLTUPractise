package com.nltu.controller;

import com.nltu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	private final CountryService countryService;

	@Autowired
	public HomeController(CountryService countryService) {
		this.countryService = countryService;
	}


//	@RequestMapping(value={"/", "/home"})
//	public String showHomePage() {
//		return "home";
//	}

    @GetMapping
	public String selectCountry(Model model){
		model.addAttribute("countries", countryService.getCountries());
		return "home";
	}


}
