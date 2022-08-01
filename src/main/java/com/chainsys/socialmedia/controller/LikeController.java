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

import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.services.LikeService;

@Controller
@RequestMapping("/like")
public class LikeController {
	@Autowired
	LikeService lservice;
	
	@GetMapping("/addlike")
	public String showAddlike(Model model) {
		Like theLike = new Like();
		model.addAttribute("addlike", theLike);
		return "add-like-form";
	}
	
	@PostMapping("/add")
	public String addNewlike(@ModelAttribute("addlike") Like theLike) {
		theLike.setDatetime();
		lservice.save(theLike);
		return "redirect:/like/list";
	}
	
	@GetMapping("/updatelike")
	public String showUpdatelike(@RequestParam("id") int id, Model model) {
		Like theLike = lservice.findById(id);
		model.addAttribute("updatelike", theLike);
		return "update-like-form";
	}
	
	@PostMapping("update")
	public String updatelikes(@ModelAttribute("updatelike") Like theLike) {
		lservice.save(theLike);
		return "redirect:/like/list";
	}
	
	@GetMapping("/findlikebyid")
	public String findlikeById(@RequestParam("id") int id, Model model) {
		Like theLike = lservice.findById(id);
		model.addAttribute("findlikebyid", theLike);
		return "find-like-id-form";
	}
	
	@GetMapping("/deletelike")
	public String deleteDoctors(@RequestParam("id") int id) {
		lservice.deleteById(id);
		return "redirect:/like/list";
	}
	
	@GetMapping("/list")
	public String getlikes(Model model) {
		List<Like> thelikes = lservice.getLikes();
		model.addAttribute("alllike", thelikes);
		return "list-likes";
	}
}
