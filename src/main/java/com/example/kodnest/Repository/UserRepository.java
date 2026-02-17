package com.example.kodnest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kodnest.Entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{
	User findByEmailId(String emailId);
}
