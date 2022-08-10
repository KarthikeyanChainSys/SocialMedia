package com.chainsys.socialmedia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.socialmedia.dto.UserFriendDTO;
import com.chainsys.socialmedia.dto.UserPostDTO;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/adduser")
	public String addNewUser(Model model) {
		User theUser = new User();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addUser(@Valid @ModelAttribute("adduser") User theUser, Errors errors) {
		if(errors.hasErrors()) {
			return "add-user-form";
		}
		userService.save(theUser);
		return "redirect:/home/login";
	}
	
	@GetMapping("/updateuser")
	public String updateUserDetails(@RequestParam("id") int id, Model model) {
		User theUser = userService.findById(id);
		model.addAttribute("updateuser", theUser);
		theUser.getUserId();
		return "update-user-form";
	}
	
	@PostMapping("/update")
	public String updateUser(@Valid @ModelAttribute("updateuser") User theUser, Errors errors) {
		if(errors.hasErrors()) {
			return "update-user-form"; 
			}
		userService.save(theUser);
		return "homepage";
	}
	
	@GetMapping("/finduserbyid")
	public String findUserById(@RequestParam("id") int id, Model model) {
		User theUser = userService.findById(id);
		model.addAttribute("finduserbyid", theUser);
		return "find-user-id-form";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("id") int id) {
		userService.deleteById(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String getAllUser(Model model) {
		List<User> theUsers = userService.getUsers();
		model.addAttribute("alluser", theUsers);
		return "list-users";
	}
	
	@GetMapping("/getuserfriend")
	public String getUserAndFriend(@RequestParam("id") int id, Model model) {
		UserFriendDTO dto = userService.getUserAndFriend(id);
		model.addAttribute("getuser", dto.getUser());
		model.addAttribute("friendlist", dto.getFriendList());
		return "list-user-friend";
	}
	
	@GetMapping("/getuserpost")
	public String getUserAndPost(@RequestParam("id") int id, Model model) {
		UserPostDTO dto = userService.getUserAndPost(id);
		model.addAttribute("getuser",dto.getUser());
		model.addAttribute("postlist", dto.getPostList());
		return "list-user-post";
	}
}
