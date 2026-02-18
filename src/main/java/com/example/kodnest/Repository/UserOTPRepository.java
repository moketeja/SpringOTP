package com.example.kodnest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kodnest.Entity.Userotp;

public interface UserOTPRepository extends JpaRepository<Userotp, Integer>{
	Userotp findByOtp(String otp);
}
