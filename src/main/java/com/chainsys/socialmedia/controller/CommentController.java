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

import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.services.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentservice;
	
	@GetMapping("/addcomment")
	public String AddNewComment(Model model) {
		Comment theComment = new Comment();
		model.addAttribute("addcomment", theComment);
		return "add-comment-form";
	}
	
	@PostMapping("/add")
	public String addComment(@ModelAttribute("addcomment") Comment theComment) {
		theComment.setDates();
		theComment.setTimes();
		commentservice.save(theComment);
		return "redirect:/comment/list";
	}
	
	@GetMapping("/updatecomment")
	public String updateCommentDetails(@RequestParam("id") int id, Model model) {
		Comment theComment = commentservice.findById(id);
		model.addAttribute("updatecomment", theComment);
		return "update-comment-form";
	}
	
	@PostMapping("update")
	public String updateComment(@ModelAttribute("updatecomment") Comment theComment) {
		theComment.setDates();
		theComment.setTimes();
		commentservice.save(theComment);
		return "redirect:/comment/list";
	}
	
	@GetMapping("/findcommentbyid")
	public String findCommentById(@RequestParam("id") int id, Model model) {
		Comment theComment = commentservice.findById(id);
		model.addAttribute("findcommentbyid", theComment);
		return "find-comment-id-form";
	}
	
	@GetMapping("/deletecomment")
	public String deleteComment(@RequestParam("id") int id) {
		commentservice.deleteById(id);
		return "redirect:/comment/list";
	}
	
	@GetMapping("/list")
	public String getAllComments(Model model) {
		List<Comment> theComments = commentservice.getComments();
		model.addAttribute("allcomment", theComments);
		return "list-comments";
	}
}
