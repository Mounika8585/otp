package com.fable.weatherall.Admin_User_Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;
    
    @Column(name = "email", length = 50)
	private String email;
    
    private String confirmpassword;

  
	public int getAdminId() {
		return adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
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

	public Admin(int adminId, String username, String password, String email, String confirmpassword) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", confirmpassword=" + confirmpassword + "]";
	}

	public Admin() {
		super();
	}



}
