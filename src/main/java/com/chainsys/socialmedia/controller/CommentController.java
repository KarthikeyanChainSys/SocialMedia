package com.chainsys.socialmedia.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.chainsys.socialmedia.commonutil.InvalidInputDataException;
import com.chainsys.socialmedia.commonutil.LogManager;
import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.services.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	private static final String ERROR = "Error"; 
	private static final String ERROR_PAGE = "error-page";
	@Autowired
	CommentService commentservice;
	
	@GetMapping("/addcomment")
	public String addNewComment(@RequestParam("id") int postId, HttpServletRequest request, Model model) {
		Comment theComment = new Comment();
		theComment.setPostId(postId);
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		theComment.setFriendId(userId);
		model.addAttribute("addcomment", theComment);
		List<Comment> theComments = commentservice.getComments(postId);
		model.addAttribute("allcomment", theComments);
		return "add-comment-form";
	}
	
	@PostMapping("/add")
	public String addComment(@ModelAttribute("addcomment") Comment theComment, @RequestParam("photo") MultipartFile photo, Model model) {
		theComment.setDate();
		theComment.setTime();
		try {
			theComment.setComments(photo.getBytes());
		} catch (IOException e) {
			//
			LogManager.logException(e, "CommentController.addComment");
		}
		try {
			commentservice.save(theComment);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		return "redirect:/comment/addcomment?id=" + theComment.getPostId() + "&fid=" + theComment.getFriendId();
	}
	
	@GetMapping("/updatecomment")
	public String updateCommentDetails(@RequestParam("id") int id, Model model) {
		Comment theComment = commentservice.findById(id);
		model.addAttribute("updatecomment", theComment);
		return "update-comment-form";
	}
	
	@PostMapping("update")
	public String updateComment(@ModelAttribute("updatecomment") Comment theComment, Model model) {
		try {
			commentservice.save(theComment);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		theComment.setDate();
		theComment.setTime();
		return "redirect:/comment/list";
	}
	
	@GetMapping("/findcommentbyid")
	public String findCommentById(@RequestParam("id") int id, Model model) {
		Comment theComment = null;
		try {
			theComment = commentservice.findById(id);
			if(theComment==null) {
				throw new InvalidInputDataException("Cannot find comment details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("findcommentbyid", theComment);
		return "find-comment-id-form";
	}
	
	@GetMapping("/deletecomment")
	public String deleteComment(@RequestParam("id") int id, Model model) {
		try {
			commentservice.deleteById(id);
			if(id==0) {
				throw new InvalidInputDataException("Cannot delete comment details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		
		return "redirect:/comment/list";
	}
	
	@GetMapping("/list")
	public String getAllComments(Model model) {
		List<Comment> theComments = null;
		try {
			theComments = commentservice.getComments();
			if(theComments==null) {
				throw new InvalidInputDataException("Cannot show comment details");
			}
		} catch (InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
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
