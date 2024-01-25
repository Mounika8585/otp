package com.fable.weatherall.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Weather_Home_Controller {

	@GetMapping("/home")
    public String displayHome() {
        return "Homepage";
    }
	
	@GetMapping("/login")
	public String displayLogin() {
        return "comlogin";
    }
	
	@GetMapping("/signup")
	public String displaySignup() {
        return "signup";
    }
	
	@GetMapping("/user_dashboard")
	public String displayUserDashboard() {
        return "user";
    }
	
	@GetMapping("/admin")
	public String displayAdminDashboard() {
        return "admin";
    }
	
	@GetMapping("/about")
	public String displayAboutPage() {
        return "about";
    }
	
}