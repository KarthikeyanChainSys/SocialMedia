package com.chainsys.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainsys.socialmedia.pojo.Users;
import com.chainsys.socialmedia.services.UserService;


@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService urservice;
	
	@GetMapping("/adduser")
	public String showAddUser(Model model) {
		Users theUser = new Users();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addNewUser(@ModelAttribute("adduser") Users theUser) {
		urservice.save(theUser);
		return "redirect:/user/list";
	}
}
