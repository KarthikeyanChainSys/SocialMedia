package com.chainsys.socialmedia.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
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

import com.chainsys.socialmedia.dto.UserFriendDTO;
import com.chainsys.socialmedia.dto.UserPostDTO;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/adduser")
	public String addNewUser(Model model) {
		User theUser = new User();
		model.addAttribute("adduser", theUser);
		return "add-user-form";
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("adduser") User theUser, @RequestParam("photo") MultipartFile photo) {
		try {
			theUser.setProfile(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		userService.save(theUser);
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
	public String updateUser(@Valid @ModelAttribute("updateuser") User theUser, Errors errors, Model model, HttpSession session) {
		if(errors.hasErrors()) {
			return "update-user-form"; 
			}
		userService.save(theUser);
		model.addAttribute("user",theUser);
		session.setAttribute("userId", theUser.getUserId());
		return "homepage";
	}
	
	@GetMapping("/finduserbyid")
	public String findUserById(@RequestParam("id") int id, Model model) {
		User theUser = userService.findById(id);
		model.addAttribute("finduserbyid", theUser);
		return "find-user-id-form";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("id") int id) {
		userService.deleteById(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String getAllUser(@RequestParam("id")int id,Model model) {
		List<User> theUsers = userService.getUsersWithoutFriends(id);
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
	
	@ResponseBody
	@GetMapping("/getimage")
	public ResponseEntity<byte[]> getImage(@RequestParam("id") int id){
		byte[] imageBytes = userService.getUserImageByteArray(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
}
