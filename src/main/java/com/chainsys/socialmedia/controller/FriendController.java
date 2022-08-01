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

import com.chainsys.socialmedia.pojo.Friend;
import com.chainsys.socialmedia.services.FriendService;


@Controller
@RequestMapping("/friend")
public class FriendController {
	@Autowired
	FriendService frservice;
	
	@GetMapping("/addfriend")
	public String showAddFriend(Model model) {
		Friend theFriend = new Friend();
		model.addAttribute("addfriend", theFriend);
		return "add-friend-form";
	}
	
	@PostMapping("/add")
	public String addNewFriend(@ModelAttribute("addfriend") Friend theFriend) {
		frservice.save(theFriend);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/updatefriend")
	public String showUpdateFriend(@RequestParam("id") int id, Model model) {
		Friend theFriend = frservice.findById(id);
		model.addAttribute("updatefriend", theFriend);
		return "update-friend-form";
	}
	
	@PostMapping("update")
	public String updateFriends(@ModelAttribute("updatefriend") Friend theFriends) {
		frservice.save(theFriends);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/findfriendbyid")
	public String findFriendById(@RequestParam("id") int id, Model model) {
		Friend theFriend = frservice.findById(id);
		model.addAttribute("findfriendbyid", theFriend);
		return "find-friend-id-form";
	}
	
	@GetMapping("/deletefriend")
	public String deleteDoctors(@RequestParam("id") int id) {
		frservice.deleteById(id);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/list")
	public String getFriends(Model model) {
		List<Friend> theFriends = frservice.getFriends();
		model.addAttribute("allfriend", theFriends);
		return "list-friends";
	}
}