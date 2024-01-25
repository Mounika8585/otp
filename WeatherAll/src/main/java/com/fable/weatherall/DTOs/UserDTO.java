package com.fable.weatherall.DTOs;

public class UserDTO {
	
	private int userid;
	private String username;
	private String email;
	private String password;
	private String confirmpassword;
	private String otp;
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	private String userType;
	
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", userType=" + userType + "]";
	}
	public UserDTO() {
		super();
	}
	public UserDTO(String username, String email, String password, String confirmpassword,String userType) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.userType = userType;
		
	}
	

	
}
