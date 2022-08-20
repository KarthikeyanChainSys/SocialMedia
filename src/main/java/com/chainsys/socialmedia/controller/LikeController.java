package com.chainsys.socialmedia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.LikeService;
import com.chainsys.socialmedia.services.UserService;

@Controller
@RequestMapping("/like")
public class LikeController {
	@Autowired
	LikeService likeservice;
	@Autowired
	UserService userService;
	
	@GetMapping("/addlike")
	public String addNewLike(@RequestParam("id") int id, @RequestParam("fid") int friendId, Model model,HttpServletRequest request) {
		Like theLike = new Like();
		theLike.setPostId(id);
		theLike.setFriendId(friendId);
		theLike.setDateTime();
		likeservice.save(theLike);
		User user = userService.findById(friendId);
		model.addAttribute("user", user);
		return "redirect:/posts/list2?userId="+friendId;
	}
	
	@PostMapping("/add")
	public String addLike(@Valid @ModelAttribute("addlike") Like theLike, Errors errors) {
		theLike.setDateTime();
		if(errors.hasErrors()) {
			return "add-like-form";
		}
		likeservice.save(theLike);
		return "redirect:/like/list?id="+theLike.getPostId() + "&fid="+theLike.getFriendId();
	}
	
	@GetMapping("/updatelike")
	public String updateLikeDetails(@RequestParam("id") int id, Model model) {
		Like theLike = likeservice.findById(id);
		model.addAttribute("updatelike", theLike);
		return "update-like-form";
	}
	
	@PostMapping("/update")
	public String updateLike(@Valid @ModelAttribute("updatelike") Like theLike, Errors errors) {
		theLike.setDateTime();
		if(errors.hasErrors()) {
			return "update-like-form";
		}
		likeservice.save(theLike);
		return "redirect:/like/list";
	}
	
	@GetMapping("/findlikebyid")
	public String findLikeById(@RequestParam("id") int id, Model model) {
		Like theLike = likeservice.findById(id);
		model.addAttribute("findlikebyid", theLike);
		return "find-like-id-form";
	}
	
	@GetMapping("/deletelike")
	public String deleteLike(@RequestParam("id") int id) {
		likeservice.deleteById(id);
		return "redirect:/like/list";
	}
	
	@GetMapping("/list")
	public String getLikes(Model model) {
		List<Like> thelikes = likeservice.getLikes();
		model.addAttribute("alllike", thelikes);
		return "list-likes";
	}
}
