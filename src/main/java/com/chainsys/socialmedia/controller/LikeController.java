package com.chainsys.socialmedia.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.socialmedia.commonutil.InvalidInputDataException;
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.LikeService;
import com.chainsys.socialmedia.services.UserService;

@Controller
@RequestMapping("/like")
public class LikeController {
	private static final String ERROR = "Error"; 
	private static final String ERROR_PAGE = "error-page";
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
	public String addLike(@ModelAttribute("addlike") Like theLike, Model model) {
		try {
			likeservice.save(theLike);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		theLike.setDateTime();
		return "redirect:/like/list?id="+theLike.getPostId() + "&fid="+theLike.getFriendId();
	}
	
	@GetMapping("/updatelike")
	public String updateLikeDetails(@RequestParam("id") int id, Model model) {
		Like theLike = likeservice.findById(id);
		model.addAttribute("updatelike", theLike);
		return "update-like-form";
	}
	
	@PostMapping("/update")
	public String updateLike(@ModelAttribute("updatelike") Like theLike, Model model) {
		try {
			likeservice.save(theLike);
		} catch(Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		theLike.setDateTime();
		return "redirect:/like/list";
	}
	
	@GetMapping("/findlikebyid")
	public String findLikeById(@RequestParam("id") int id, Model model) {
		Like theLike = null;
		try {
			theLike = likeservice.findById(id);
			if(theLike==null) {
				throw new InvalidInputDataException("Cannot find like details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("findlikebyid", theLike);
		return "find-like-id-form";
	}
	
	@GetMapping("/deletelike")
	public String deleteLike(@RequestParam("id") int id, Model model) {
		try {
			likeservice.deleteById(id);
			if(id==0) {
				throw new InvalidInputDataException("Cannot delete like details");
			}
		} catch (InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		return "redirect:/like/list";
	}
	
	@GetMapping("/list")
	public String getLikes(Model model) {
		List<Like> thelikes = null;
		try {
			thelikes = likeservice.getLikes();
			if(thelikes==null) {
				throw new InvalidInputDataException("Cannot show like details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("alllike", thelikes);
		return "list-likes";
	}
}
