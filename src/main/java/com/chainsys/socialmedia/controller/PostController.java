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

import com.chainsys.socialmedia.pojo.Post;
import com.chainsys.socialmedia.services.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostService pservice;
	
	@GetMapping("/addpost")
	public String showAddPost(Model model) {
		Post thePost = new Post();
		model.addAttribute("addpost", thePost);
		return "add-post-form";
	}
	
	@PostMapping("/add")
	public String addNewPost(@ModelAttribute("addpost") Post thePost) {
		thePost.setDates();
		thePost.setTimes();
		pservice.save(thePost);
		return "redirect:/posts/list";
	}
	
	@GetMapping("/updatepost")
	public String showUpdatePost(@RequestParam("id") int id, Model model) {
		Post thePost = pservice.findById(id);
		model.addAttribute("updatepost", thePost);
		return "update-post-form";
	}
	
	@PostMapping("update")
	public String updatePosts(@ModelAttribute("updatepost") Post thePost) {
		thePost.getDates();
		thePost.getTimes();
		pservice.save(thePost);
		return "redirect:/posts/list";
	}
	
	@GetMapping("/findpostbyid")
	public String findPostById(@RequestParam("id") int id, Model model) {
		Post thePost = pservice.findById(id);
		model.addAttribute("findpostbyid", thePost);
		return "find-post-id-form";
	}
	
	@GetMapping("/deletepost")
	public String deleteDoctors(@RequestParam("id") int id) {
		pservice.deleteById(id);
		return "redirect:/posts/list";
	}
	
	@GetMapping("/list")
	public String getPosts(Model model) {
		List<Post> thePosts = pservice.getPosts();
		model.addAttribute("allpost", thePosts);
		return "list-posts";
	}
}
