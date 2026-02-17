package com.example.kodnest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kodnest.Entity.User;
import com.example.kodnest.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public void register(User user) {
		userRepo.save(user);
	}
}
