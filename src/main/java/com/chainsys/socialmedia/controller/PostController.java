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
import com.chainsys.socialmedia.dto.PostCommentDTO;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.services.FriendService;
import com.chainsys.socialmedia.services.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostService postservice;
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/addpost")
	public String addNewPost(@RequestParam("userId") int id, Model model) {
		Post thePost = new Post();
		thePost.setUserId(id);
		model.addAttribute("addpost", thePost);
		return "add-post-form";
	}
	
	@PostMapping("/add")
	public String addPost(@ModelAttribute("addpost") Post thePost, @RequestParam("photo") MultipartFile photo) {
		try {
			thePost.setPosts(photo.getBytes());
		} catch (IOException e) {
			//
		}
		thePost.setDate();
		thePost.setTime();
		int id = thePost.getUserId();
		postservice.save(thePost);
		return "redirect:/posts/list?userId="+id;
	}
	
	@GetMapping("/updatepost")
	public String updatePostDetails(@RequestParam("id") int id, Model model) {
		Post thePost = postservice.findById(id);
		model.addAttribute("updatepost", thePost);
		return "update-post-form";
	}
	
	@PostMapping("update")
	public String updatePost(@Valid @ModelAttribute("updatepost") Post thePost, Errors errors) {
		thePost.setDate();
		thePost.setTime();
		if(errors.hasErrors()) {
			return "update-post-form";
		}
		postservice.save(thePost);
		return "homepage";
	}
	
	@GetMapping("/findpostbyid")
	public String findPostById(@RequestParam("id") int id, Model model) {
		Post thePost = postservice.findById(id);
		model.addAttribute("findpostbyid", thePost);
		return "find-post-id-form";
	}
	
	@GetMapping("/deletepost")
	public String deletePost(@RequestParam("id") int id) {
		Post post = postservice.findById(id);
		postservice.deleteById(id);
		int userId = post.getUserId();
		return "redirect:/posts/list2?userId="+userId;
	}
	
	@GetMapping("/getPostByUserId")
	public String getPostByUserId(@RequestParam("id")int id,Model model) {
		List<Post>postList=postservice.findByUserId(id);
		model.addAttribute("allpost", postList);
		return "list-posts";
	}
	
	@GetMapping("/list")
	public String getAllPosts(@RequestParam("userId")int userId , Model model) {
		List<Friend>friendList=friendService.findByUserId(userId);
		List<Post> postList = postservice.getPost(friendList);
		model.addAttribute("userId", userId);
		model.addAttribute("allpost", postList);
		return "list-posts";
	}
	
	@GetMapping("/list2")
	public String getPosts(@RequestParam("userId")int userId , Model model) {
		List<Friend>friendList=friendService.findByUserId(userId);
		List<Post> postList = postservice.getPost(friendList);
		model.addAttribute("userId", userId);
		model.addAttribute("allpost", postList);
		return "list-posts2";
	}
	
	@GetMapping("/getpostcomment")
	public String getPostAndComment(@RequestParam("id") int id, Model model) {
		PostCommentDTO dto = postservice.getPostAndComment(id);
		model.addAttribute("getpost", dto.getPost());
		model.addAttribute("commentlist", dto.getCommentList());
		return "list-post-comment";
	}
	
	@ResponseBody
	@GetMapping("/getimage")
	public ResponseEntity<byte[]> getImage(@RequestParam("id") int id) {
		byte[] imageBytes = postservice.getPostImageByteArray(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
}