package com.fable.weatherall.DTOs;

public class AdminDTO {
    private String username;
    private String password;
    private String email;
	private String confirmpassword;
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public AdminDTO(String username, String password, String email, String confirmpassword) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirmpassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "AdminDTO [username=" + username + ", password=" + password + ", email=" + email + ", confirmpassword="
				+ confirmpassword + "]";
	}
	
	
	

}
