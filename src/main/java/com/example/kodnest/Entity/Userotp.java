package com.example.kodnest.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Userotp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int otpid;
	
	@Column
	String otp;
	
	@Column
	int userId;
	
	@Column
	LocalDateTime createdTime;

	public Userotp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userotp(int otpid, String otp, int userId, LocalDateTime createdTime) {
		super();
		this.otpid = otpid;
		this.otp = otp;
		this.userId = userId;
		this.createdTime = createdTime;
	}

	public int getOtpid() {
		return otpid;
	}

	public void setOtpid(int otpid) {
		this.otpid = otpid;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
	
}