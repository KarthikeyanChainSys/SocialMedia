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

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.services.FriendService;


@Controller
@RequestMapping("/friend")
public class FriendController {
	@Autowired
	FriendService friendservice;
	
	@GetMapping("/addfriend")
	public String addNewFriend(Model model) {
		Friend theFriend = new Friend();
		model.addAttribute("addfriend", theFriend);
		return "add-friend-form";
	}
	
	@PostMapping("/add")
	public String addFriend(@ModelAttribute("addfriend") Friend theFriend) {
		friendservice.save(theFriend);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/updatefriend")
	public String updateFriendDetails(@RequestParam("id") int id, Model model) {
		Friend theFriend = friendservice.findById(id);
		model.addAttribute("updatefriend", theFriend);
		return "update-friend-form";
	}
	
	@PostMapping("update")
	public String updateFriend(@ModelAttribute("updatefriend") Friend theFriend) {
		friendservice.save(theFriend);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/findfriendbyid")
	public String findFriendById(@RequestParam("id") int id, Model model) {
		Friend theFriend = friendservice.findById(id);
		model.addAttribute("findfriendbyid", theFriend);
		return "find-friend-id-form";
	}
	
	@GetMapping("/deletefriend")
	public String deleteFriend(@RequestParam("id") int id) {
		friendservice.deleteById(id);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/list")
	public String getAllFriends(Model model) {
		List<Friend> theFriends = friendservice.getFriends();
		model.addAttribute("allfriend", theFriends);
		return "list-friends";
	}
}