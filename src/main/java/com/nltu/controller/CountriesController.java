package com.nltu.controller;

import com.nltu.entity.Country;
import com.nltu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountriesController {

    private final CountryService countryService;

    @Autowired
    public CountriesController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String showCountries(Model model) {
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);

        return "countries/index";
    }

    @GetMapping("/{id}")
    public String showCountry(@PathVariable("id") int id, Model model) {
        model.addAttribute("country", countryService.getCountry(id));
        return "countries/show";
    }

    @GetMapping("/new")
    public String newCountry(Model model) {
        model.addAttribute("country", new Country());
        return "countries/new";
    }

    @PostMapping
    public String createCountry(@ModelAttribute("country") Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/{id}/edit")
    public String editCountry(@PathVariable("id") int id, Model model) {
        model.addAttribute("country", countryService.getCountry(id));
        return "countries/edit";
    }

    @PatchMapping("/{id}")
    public String updateCountry(@ModelAttribute("country") Country country) {
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }
}
