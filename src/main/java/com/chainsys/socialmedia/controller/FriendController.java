package com.chainsys.socialmedia.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.businesslogic.Logic;
import com.chainsys.socialmedia.commonutil.InvalidInputDataException;
import com.chainsys.socialmedia.compositekey.FriendCompositeKey;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.services.FriendService;

@Controller
@RequestMapping("/friend")
public class FriendController {
	private static final String ERROR = "Error"; 
	private static final String ERROR_PAGE = "error-page";
	@Autowired
	FriendService friendService;
	
	@GetMapping("/addfriend")
	public String addNewFriend(@RequestParam("friendId")int friendId, @RequestParam("userId")int userId,Model model) {
		Friend theFriend = new Friend();
		theFriend.setFriendId(friendId);
		theFriend.setUserId(userId);
		theFriend.setRequestStatus("request");
		friendService.save(theFriend);
		model.addAttribute("addfriend", theFriend);
		return "redirect:/user/list?id="+userId;
	}
	
	@PostMapping("/add")
	public String addFriend(@ModelAttribute("addfriend") Friend theFriend, Model model) {
		try {
			friendService.save(theFriend);
		} catch (Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
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
	public String updateFriend(@ModelAttribute("updatefriend") Friend theFriend, Model model) {
		try {
			friendService.save(theFriend);
		} catch (Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
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
	public String deleteFriend(@RequestParam("id") int friendId, @RequestParam("userId") int userId, Model model) {
		FriendCompositeKey friendcompositekey = new FriendCompositeKey(friendId,userId);
		friendService.deleteById(friendcompositekey);
		return "redirect:/friend/request?id="+userId;
	}
	
	@GetMapping("/list")
	public String getAllFriend(@RequestParam("id")int id,Model model) {
		List<Friend> theFriend = null;
		try {
			theFriend = friendService.getFriends();
			if(theFriend==null) {
				throw new InvalidInputDataException("Cannot find friends details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("friendId", id);
		model.addAttribute("allfriend", theFriend);
		return "list-friends";
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
		model.addAttribute("requestLists", requestList);
		return "request-details";
	}
}