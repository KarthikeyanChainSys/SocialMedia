package com.chainsys.socialmedia.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.socialmedia.commonutil.InvalidInputDataException;
import com.chainsys.socialmedia.dto.UserFriendDTO;
import com.chainsys.socialmedia.dto.UserPostDTO;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	private static final String ERROR = "Error"; 
	private static final String ERROR_PAGE = "error-page";
	@Autowired
	UserService userService;
	
	@GetMapping("/adduser")
	public String addNewUser(Model model) {
		User theUser = new User();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("adduser") User theUser, Model model) {
		try {
			userService.save(theUser);
		} catch (Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}	
		return "redirect:/home/login";
	}
	
	@GetMapping("/updateuser")
	public String updateUserDetails(@RequestParam("id") int id, Model model) {
		User theUser = userService.findById(id);
		model.addAttribute("updateuser", theUser);
		theUser.getUserId();
		return "update-user-form";
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("updateuser") User theUser, Model model, HttpSession session) {
		try {
			userService.save(theUser);
			model.addAttribute("user",theUser);
			session.setAttribute("userId", theUser.getUserId());
		} catch (Exception e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		return "homepage";
	}
	
	@GetMapping("/finduserbyid")
	public String findUserById(@RequestParam("id") int id, Model model) {
		User theUser = null;
		try {
			theUser = userService.findById(id);
			if(theUser==null) {
				throw new InvalidInputDataException("Cannot find user details");
			}
		} catch (InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("finduserbyid", theUser);
		return "find-user-id-form";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("id") int id, Model model) {
		try {
			userService.deleteById(id);
			if(id==0) {
				throw new InvalidInputDataException("Cannot delete user details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String getAllUser(@RequestParam("id")int id,Model model) {
		List<User> theUsers = null;
		try {
			theUsers = userService.getUsersWithoutFriends(id);
			if(theUsers==null) {
				throw new InvalidInputDataException("Cannot find user details");
			}
		} catch(InvalidInputDataException e) {
			model.addAttribute(ERROR, e.getMessage());
			return ERROR_PAGE;
		}
		model.addAttribute("userId", id);
		model.addAttribute("alluser", theUsers);
		return "list-users";
	}
	
	@GetMapping("/getuserfriend")
	public String getUserAndFriend(@RequestParam("id") int id, Model model) {
		UserFriendDTO dto = userService.getUserAndFriend(id);
		model.addAttribute("getuser", dto.getUser());
		model.addAttribute("friendlist", dto.getFriendList());
		return "list-user-friend";
	}
	
	@GetMapping("/getuserpost")
	public String getUserAndPost(@RequestParam("id") int id, Model model) {
		
		UserPostDTO dto = userService.getUserAndPost(id);
		model.addAttribute("getuser",dto.getUser());
		model.addAttribute("postlist", dto.getPostList());
		return "list-user-post";
	}
}
