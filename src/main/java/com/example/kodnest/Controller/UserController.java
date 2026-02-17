package com.example.kodnest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kodnest.Entity.User;
import com.example.kodnest.Service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String displaySignUpPage() {
		return "index";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		userServ.register(user);
		System.out.println("Register Successfull");
		return "login";
	}
	
	
}
