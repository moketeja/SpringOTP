package com.example.kodnest.Service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.kodnest.Entity.User;
import com.example.kodnest.Entity.Userotp;
import com.example.kodnest.Repository.UserOTPRepository;
import com.example.kodnest.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserOTPRepository userOtpRepo;
	
	@Autowired
	JavaMailSender mailSender;
	
	public void register(User user) {
		userRepo.save(user);
	}
	
	public boolean loginAndGenerateOTP(String email, String password) {
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		if(!user.getPassword().equals(password)) {
			return false;
		}
		
		int otpNum = new Random().nextInt(100000, 1000000);
		String otp = String.valueOf(otpNum);
		
		Userotp userOtp=new Userotp();
		userOtp.setOtp(otp);
		userOtp.setUserId(user.getId());
		userOtp.setCreatedTime(LocalDateTime.now());
		
		userOtpRepo.save(userOtp);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("Your OTP code");
		message.setText("Hello " + user.getName() +". Your OTP code is: " + otp + ". This Otp Expires in 2 mins. ThankYou🤷‍♂️");
		mailSender.send(message);
		return true;
	}
	
	public boolean verifyOtp(String otp) {
		Userotp userOtp = userOtpRepo.findByOtp(otp);
		if(userOtp == null) {
			return false;
		}
		LocalDateTime expiryTime = userOtp.getCreatedTime().plusMinutes(2);
		if (LocalDateTime.now().isAfter(expiryTime)) {
			return false;
		}
		return true;
	}
}
