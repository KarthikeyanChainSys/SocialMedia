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

import com.chainsys.socialmedia.businessLogic.Logic;
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
		return "redirect:/friend/list";
	}
	
	@GetMapping("/updatefriend")
	public String updateFriendDetails(@RequestParam("id1") int id1,@RequestParam("id2") int id2, Model model) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(id1,id2);
		Optional<Friend> theFriend = friendService.findById(friendcompositekey);
		model.addAttribute("updatefriend", theFriend);
		return "update-friend-form";
	}
	
	@PostMapping("update")
	public String updateFriend(@Valid @ModelAttribute("updatefriend") Friend theFriend, Errors errors) {
		if(errors.hasErrors()) {
			return "update-friend-form";
		}
		friendService.save(theFriend);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/findfriendbyid")
	public String findFriendById(@RequestParam("id1") int id1, @RequestParam("id2") int id2, Model model) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(id1,id2);
		Optional<Friend> theFriend = friendService.findById(friendcompositekey);
		model.addAttribute("findfriendbyid", theFriend);
		return "find-friend-id-form";
	}
	
	@GetMapping("/deletefriend")
	public String deleteFriend(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(id1,id2);
		friendService.deleteById(friendcompositekey);
		return "redirect:/friend/list";
	}
	
	@GetMapping("/request")
	public String getAllFriends(@RequestParam("id")int userId,Model model) {
		List<Friend> theFriends = friendService.findByUserId(userId);
		List<Friend>requestList=Logic.getRequestList(theFriends);
		model.addAttribute("requestList", requestList);
		return "list-friends";
	}
	
	@GetMapping("/getFriendByUserId")
	public String getfriendByUserId(@RequestParam("id")int id, Model model) {
		List<Friend> friendList = friendService.findByUserId(id);
		model.addAttribute("allfriend", friendList);
		return "list-friends";
	}
	
//	@GetMapping("/getfriendcomment")
//	public String getFriendAndComment(@RequestParam("id") int id, Model model) {
//		FriendCommentDTO dto = friendService.getFriendAndComment(id);
//		model.addAttribute("getfriend", dto.getFriend());
//		model.addAttribute("commentlist", dto.getCommentList());
//		return "list-friend-comment";
//	}
//	
//	@GetMapping("/getfriendlike")
//	public String getFriendAndLike(@RequestParam("id") int id, Model model) {
//		FriendLikeDTO dto = friendService.getFriendAndLike(id);
//		model.addAttribute("getfriend", dto.getFriend());
//		model.addAttribute("likelist", dto.getLike());
//		return "list-friend-like";
//	}
}