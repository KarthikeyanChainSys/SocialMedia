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

import com.chainsys.socialmedia.pojo.User;
import com.chainsys.socialmedia.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService urservice;
	
	@GetMapping("/adduser")
	public String showAddUser(Model model) {
		User theUser = new User();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addNewUser(@ModelAttribute("adduser") User theUser) {
		urservice.save(theUser);
		return "redirect:/user/list";
	}
	
	@GetMapping("/updateuser")
	public String showUpdateUser(@RequestParam("id") int id, Model model) {
		User theUser = urservice.findById(id);
		model.addAttribute("updateuser", theUser);
		return "update-user-form";
	}
	
	@PostMapping("update")
	public String updateUsers(@ModelAttribute("updateuser") User theUsers) {
		urservice.save(theUsers);
		return "redirect:/user/list";
	}
	
	@GetMapping("/finduserbyid")
	public String findUserById(@RequestParam("id") int id, Model model) {
		User theUser = urservice.findById(id);
		model.addAttribute("finduserbyid", theUser);
		return "find-user-id-form";
	}
	
	@GetMapping("/deleteuser")
	public String deleteDoctors(@RequestParam("id") int id) {
		urservice.deleteById(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String getUsers(Model model) {
		List<User> theUsers = urservice.getUsers();
		model.addAttribute("alluser", theUsers);
		return "list-users";
	}
}
