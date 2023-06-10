package com.nltu.controller;

import com.nltu.entity.User;
import com.nltu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
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
       userService.save(user);
       return "redirect:/login";
    }
}
