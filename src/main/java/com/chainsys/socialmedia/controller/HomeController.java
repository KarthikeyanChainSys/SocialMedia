package com.chainsys.socialmedia.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chainsys.socialmedia.model.Login;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.services.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login-form";
	}

	@PostMapping("/userPage")
	public String loginPage(@ModelAttribute("login")Login login, Model model,HttpSession session) {
		User user = userService.getEmailAndPassword(login.getEmail(), login.getPassword());
		if(user != null) {
			model.addAttribute("user", user);
			session.setAttribute("userId", user.getUserId());
			return "homepage";
		} else {
			model.addAttribute("result", "Password or Email Id is wrong");
			return "login-form";	
		}
	}

}
