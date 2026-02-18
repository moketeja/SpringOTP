package com.example.kodnest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/login")
	public String displayLoginPage() {
		return "login";
	}
	
	
	@PostMapping("/login") 
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		boolean status = userServ.loginAndGenerateOTP(email, password);
		if(status==true) {
			return "otp";
		}
		else {
			return "loginfail";
		}
	}
	
	@PostMapping("/verifyotp")
	public String verifyOTP(@RequestParam String otp) {
		boolean status = userServ.verifyOtp(otp);
		if(status == true) {
			return "homepage";
		}
		else {
			return "loginfail";
		}
	}
}
