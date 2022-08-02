package com.chainsys.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/adduser")
	public String addNewUser(Model model) {
		User theUser = new User();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("adduser") User theUser) {
		userservice.save(theUser);
		return "redirect:/user/list";
	}
	
	@GetMapping("/updateuser")
	public String updateUserDetails(@RequestParam("id") int id, Model model) {
		User theUser = userservice.findById(id);
		model.addAttribute("updateuser", theUser);
		return "update-user-form";
	}
	
	@PostMapping("update")
	public String updateUser(@ModelAttribute("updateuser") User theUsers) {
		userservice.save(theUsers);
		return "redirect:/user/list";
	}
	
	@GetMapping("/finduserbyid")
	public String findUserById(@RequestParam("id") int id, Model model) {
		User theUser = userservice.findById(id);
		model.addAttribute("finduserbyid", theUser);
		return "find-user-id-form";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("id") int id) {
		userservice.deleteById(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String getAllUser(Model model) {
		List<User> theUsers = userservice.getUsers();
		model.addAttribute("alluser", theUsers);
		return "list-users";
	}
}
