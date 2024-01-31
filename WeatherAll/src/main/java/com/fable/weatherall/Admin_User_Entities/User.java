package com.fable.weatherall.Admin_User_Entities;

import java.time.LocalDateTime;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.*;
@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@Column(name = "user_id", length = 45)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	
	@Column(name = "user_name", length = 12)
	private String username;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "password", length = 225)
	private String password;
	@Column(name = "confirmpassword", length = 225)
	private String confirmpassword;
	@Column(name = "UserType", length = 225)
	private String userType;
	@Column(name = "otp")
	private String otp;

	


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", userType=" + userType + ", otp=" + otp + "]";
	}


	public User(int userid, String username, String email, String password, String confirmpassword,String userType) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.userType = userType;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
}
