package com.chainsys.socialmedia.controller;

import java.io.IOException;
import java.util.List;
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

import com.chainsys.socialmedia.commonutil.InvalidInputDataException;
import com.chainsys.socialmedia.dto.PostCommentDTO;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.services.FriendService;
import com.chainsys.socialmedia.services.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	private static final String ERROR = "Error"; 
	private static final String ERROR_PAGE = "error-page";
	private static final String ALLPOST = "allpost";
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
	public String addPost(@ModelAttribute("addpost") Post thePost, @RequestParam("photo") MultipartFile photo, Model model) {
		try {
			thePost.setPosts(photo.getBytes());
		} catch (IOException e) {
			//
		}
		try {
			postservice.save(thePost);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		thePost.setDate();
		thePost.setTime();
		int id = thePost.getUserId();
		return "redirect:/posts/list?userId="+id;
	}
	
	@GetMapping("/updatepost")
	public String updatePostDetails(@RequestParam("id") int id, Model model) {
		Post thePost = postservice.findById(id);
		model.addAttribute("updatepost", thePost);
		return "update-post-form";
	}
	
	@PostMapping("update")
	public String updatePost(@ModelAttribute("updatepost") Post thePost, Errors errors, Model model) {
		try {
			postservice.save(thePost);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		thePost.setDate();
		thePost.setTime();
		return "homepage";
	}
	
	@GetMapping("/findpostbyid")
	public String findPostById(@RequestParam("id") int id, Model model) {
		Post thePost = null;
		try {
			thePost = postservice.findById(id);
			if(thePost==null) {
				throw new InvalidInputDataException("Cannot find post details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}		
		model.addAttribute("findpostbyid", thePost);
		return "find-post-id-form";
	}
	
	@GetMapping("/deletepost")
	public String deletePost(@RequestParam("id") int id, Model model) {
		Post post = null;
		try {
			post = postservice.findById(id);
			postservice.deleteById(id);
			if(id==0) {
				throw new InvalidInputDataException("Cannot delete post details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		int userId = post.getUserId();
		return "redirect:/posts/list2?userId="+userId;
	}
	
	@GetMapping("/getPostByUserId")
	public String getPostByUserId(@RequestParam("id")int id,Model model) {
		List<Post>postList=postservice.findByUserId(id);
		model.addAttribute(ALLPOST, postList);
		return "list-posts";
	}
	
	@GetMapping("/list")
	public String getAllPosts(@RequestParam("userId")int userId , Model model) {
		List<Post> postList = null;
		try {
			List<Friend>friendList=friendService.findByUserId(userId);
			postList = postservice.getPost(friendList);
			if(postList==null) {
				throw new InvalidInputDataException("Cannot delete post details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("userId", userId);
		model.addAttribute(ALLPOST, postList);
		return "list-posts";
	}
	
	@GetMapping("/list2")
	public String getPosts(@RequestParam("userId")int userId , Model model) {
		List<Post> postList = null;
		try {
			List<Friend>friendList=friendService.findByUserId(userId);
			postList = postservice.getPost(friendList);
			if(postList==null) {
				throw new InvalidInputDataException("Cannot delete post details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("userId", userId);
		model.addAttribute(ALLPOST, postList);
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