package com.smartResume.lib;

import java.util.List;

public class User {
	
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String emailId;
	private String password;
	private String userId;
	private int verifiedStatus; // if email is verified status will be 1 else 0
	private int OTP; 
	private List<Resume> resumes;
	
	public int getOTP() {
		return OTP;
	}
	public void setOTP(int oTP) {
		OTP = oTP;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Resume> getResumes() {
		return resumes;
	}
	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVerifiedStatus() {
		return verifiedStatus;
	}
	public void setVerifiedStatus(int verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}
	
	
}
