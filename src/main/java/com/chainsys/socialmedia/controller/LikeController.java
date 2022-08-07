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

import com.chainsys.socialmedia.compositekey.LikeCompositeKey;
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.services.LikeService;

@Controller
@RequestMapping("/like")
public class LikeController {
	@Autowired
	LikeService likeservice;
	
	@GetMapping("/addlike")
	public String addNewLike(Model model) {
		Like theLike = new Like();
		model.addAttribute("addlike", theLike);
		return "add-like-form";
	}
	
	@PostMapping("/add")
	public String addLike(@Valid @ModelAttribute("addlike") Like theLike, Errors errors) {
		theLike.setDateTime();
		if(errors.hasErrors()) {
			return "add-like-form";
		}
		likeservice.save(theLike);
		return "redirect:/like/list";
	}
	
	@GetMapping("/updatelike")
	public String updateLikeDetails(@RequestParam("id1") int id1, @RequestParam("id2") int id2, Model model) {
		LikeCompositeKey likecompositekey = new LikeCompositeKey(id1, id2);
		Optional<Like> theLike = likeservice.findById(likecompositekey);
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
	public String findLikeById(@RequestParam("id1") int id1, @RequestParam("id2") int id2, Model model) {
		LikeCompositeKey likecompositekey = new LikeCompositeKey(id1, id2);
		Optional<Like> theLike = likeservice.findById(likecompositekey);
		model.addAttribute("findlikebyid", theLike);
		return "find-like-id-form";
	}
	
	@GetMapping("/deletelike")
	public String deleteLike(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		LikeCompositeKey likeCompositeKey = new LikeCompositeKey(id1, id2);
		likeservice.deleteById(likeCompositeKey);
		return "redirect:/like/list";
	}
	
	@GetMapping("/list")
	public String getLikes(Model model) {
		List<Like> thelikes = likeservice.getLikes();
		model.addAttribute("alllike", thelikes);
		return "list-likes";
	}
}
