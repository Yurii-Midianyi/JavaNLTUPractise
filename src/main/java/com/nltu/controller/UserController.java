package com.nltu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nltu.entity.User;
import com.nltu.service.UserService;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	@Transactional
	public String listOfUsers(Model model) {
		List<User> users = userService.getUsers();
		users.toString();//fix issue with LAZY loading
		model.addAttribute("users", users);
		return "userList";
	}
	
}
