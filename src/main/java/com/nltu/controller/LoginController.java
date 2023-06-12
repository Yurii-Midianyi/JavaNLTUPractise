package com.nltu.controller;

import com.nltu.entity.User;
import com.nltu.service.RegistrationService;
import com.nltu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;
    private final RegistrationService registrationService;
    @Autowired
    public LoginController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }
//
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public  String registration(@ModelAttribute("user") User user){
       registrationService.register(user);
       return "redirect:/login";
    }
}
