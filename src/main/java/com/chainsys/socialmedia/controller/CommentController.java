package com.chainsys.socialmedia.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.socialmedia.commonutil.LogManager;
import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.services.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentservice;
	
	@GetMapping("/addcomment")
	public String addNewComment(@RequestParam("id") int postId, @RequestParam("fid") int friendId, Model model) {
		Comment theComment = new Comment();
		theComment.setPostId(postId);
		theComment.setFriendId(friendId);
		model.addAttribute("addcomment", theComment);
		List<Comment> theComments = commentservice.getComments();
		model.addAttribute("allcomment", theComments);
		return "add-comment-form";
	}
	
	@PostMapping("/add")
	public String addComment(@ModelAttribute("addcomment") Comment theComment, @RequestParam("photo") MultipartFile photo) {
		theComment.setDate();
		theComment.setTime();
		try {
			theComment.setComments(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			LogManager.logException(e, "CommentController.addComment");
		}
		commentservice.save(theComment);
		return "redirect:/comment/addcomment?id=" + theComment.getPostId() + "&fid=" + theComment.getFriendId();
	}
	
	@GetMapping("/updatecomment")
	public String updateCommentDetails(@RequestParam("id") int id, Model model) {
		Comment theComment = commentservice.findById(id);
		model.addAttribute("updatecomment", theComment);
		return "update-comment-form";
	}
	
	@PostMapping("update")
	public String updateComment(@Valid @ModelAttribute("updatecomment") Comment theComment, Errors errors) {
		theComment.setDate();
		theComment.setTime();
		if(errors.hasErrors()) {
			return "update-comment-form";
		}
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
	
	@ResponseBody
 	@GetMapping("/getimage")
 	public ResponseEntity<byte[]> getImage(@RequestParam("id") int id)
 	{
 		byte[] imageBytes = commentservice.getCommentImageByteArray(id);
 		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
 		
 	}
}
