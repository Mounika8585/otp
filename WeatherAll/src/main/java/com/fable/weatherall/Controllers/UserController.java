package com.fable.weatherall.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.LoginDTO;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.DTOs.VerifyOtpDTO;
import com.fable.weatherall.Responses.LoginResponse;
import com.fable.weatherall.Services.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path = "/save")
	public String saveUser(@RequestBody UserDTO userDTO) {
	
		String id = userService.addUser(userDTO);
		return id;
	}
	
	//"Login Success" response in login page
	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
		LoginResponse loginResponse = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpDTO verifyOtpDTO) {
		System.out.println("verify otp");
	    boolean isOtpVerified = userService.verifyOtp(verifyOtpDTO.getEmail(), verifyOtpDTO.getOtp());
	    
	    if (isOtpVerified) {
	        return ResponseEntity.ok("OTP verified successfully");
	    } else {
	        return ResponseEntity.badRequest().body("Invalid OTP or OTP expired");
	    }
	}
	
	@PostMapping("/sendOtp/{email}")
	public String sendOtpToMail(@PathVariable("email") String email) {
		userService.sendOtpService(email);
		return "otp send successfully";
	}
	
//	@PutMapping("/forgot-passord")
//	public ResponseEntity<String> forgotPassword(@RequestParam String email){
//		return new ResponseEntity<>(userService.forgotPassword(email),HttpStatus.OK);
//	}
}
