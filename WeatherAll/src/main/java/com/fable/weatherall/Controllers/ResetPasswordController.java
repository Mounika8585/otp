package com.fable.weatherall.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.Services.UserService;

	@Controller
	public class ResetPasswordController {
		
		@Autowired
		private UserService userService;

	    @PostMapping("/resetPassword")
	    public String resetPassword(@ModelAttribute("detail") User user, Model model) {
	        System.out.println("reset password");
	        int status = userService.resetPassword(user);
	        
	        if (status == 1) {
	            model.addAttribute("message", "User is not registered");
	            return "forgetPassword";
	        } else if (status == 3) {
	            model.addAttribute("message", "Otp is not matched");
	            return "forgetPassword";
	        }
	        return "comlogin";
	    }
	}


