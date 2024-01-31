package com.fable.weatherall.Services;

import java.util.List;


import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.LoginDTO;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.Responses.LoginResponse;

import ch.qos.logback.core.model.Model;


public interface UserService {

	String addUser(User user);
	LoginResponse loginUser(LoginDTO loginDTO);
	 List<User> findAllUsers(); 
	 List<String> addMultipleUsers(List<User> userList);
	 
	 String updateUser(int userId, User user);
//	 boolean verifyOtp(String email, String otp);
//	void sendOtp(String email);
	void sendOtpService(String email);
	boolean verifyOtp(String email, String otp);
	int resetPassword(User user);
}
