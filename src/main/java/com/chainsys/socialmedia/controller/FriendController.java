package com.chainsys.socialmedia.controller;

import java.util.List;
import java.util.Optional;

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

import com.chainsys.socialmedia.businesslogic.Logic;
import com.chainsys.socialmedia.compositekey.FriendCompositeKey;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.services.FriendService;

@Controller
@RequestMapping("/friend")
public class FriendController {
	@Autowired
	FriendService friendService;
	
	@GetMapping("/addfriend")
	public String addNewFriend(@RequestParam("friendId")int friendId,@RequestParam("userId")int userId,Model model) {
		Friend theFriend = new Friend();
		theFriend.setFriendId(friendId);
		theFriend.setUserId(userId);
		theFriend.setRequestStatus("request");
		model.addAttribute("addfriend", theFriend);
		return "add-friend-form";
	}
	
	@PostMapping("/add")
	public String addFriend(@Valid @ModelAttribute("addfriend") Friend theFriend, Errors errors) {
		if(errors.hasErrors()) {
			return "add-friend-form";
		}
		friendService.save(theFriend);
		int id=theFriend.getUserId();
		return "redirect:/friend/request?id="+id;
	}
	
	@GetMapping("/updatefriend")
	public String updateFriendDetails(@RequestParam("id") int friendId,@RequestParam("userId") int userId, Model model) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(friendId,userId);
		Optional<Friend> theFriend = friendService.findById(friendcompositekey);
		theFriend.get().setRequestStatus("accept");
		friendService.save(theFriend.get());
		model.addAttribute("friends", theFriend);
		List<Friend> theFriends = friendService.findByUserId(userId);
		List<Friend>requestList=Logic.getRequestList(theFriends);
		model.addAttribute("requestList", requestList);
		return "list-request";
	}
	
	@PostMapping("update")
	public String updateFriend(@Valid @ModelAttribute("updatefriend") Friend theFriend, Errors errors) {
		if(errors.hasErrors()) {
			return "update-friend-form";
		}
		friendService.save(theFriend);
		return "redirect:/friend/request";
	}
	
	@GetMapping("/findfriendbyid")
	public String findFriendById(@RequestParam("id1") int id1, @RequestParam("id2") int id2, Model model) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(id1,id2);
		Optional<Friend> theFriend = friendService.findById(friendcompositekey);
		model.addAttribute("findfriendbyid", theFriend);
		return "find-friend-id-form";
	}
	
	@GetMapping("/deletefriend")
	public String deleteFriend(@RequestParam("id") int friendId, @RequestParam("userId") int userId) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(friendId,userId);
		friendService.deleteById(friendcompositekey);
		return "redirect:/friend/request?id="+userId;
	}
	
	@GetMapping("/request")
	public String getAllFriends(@RequestParam("id")int userId,Model model) {
		List<Friend> theFriends = friendService.findByFriendId(userId);
		List<Friend>requestList=Logic.getRequestList(theFriends);
		model.addAttribute("requestList", requestList);
		return "list-request";
	}
	
	@GetMapping("/getFriendByUserId")
	public String getfriendByUserId(@RequestParam("id")int id, Model model) {
		List<Friend> friendList = friendService.findByUserId(id);
		List<Friend>acceptList=Logic.getAcceptList(friendList);
		model.addAttribute("allfriend", acceptList);
		return "list-friends";
	}
	
	@GetMapping("/requestDetails")
	public String getRequestDetails(@RequestParam("id") int userId, Model model) {
		List<Friend> theFriends = friendService.findByUserId(userId);
		List<Friend>requestList=Logic.getRequestList(theFriends);
		model.addAttribute("requestList", requestList);
		return "request-details";
	}
}