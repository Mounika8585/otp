package com.fable.weatherall.ServicesImpl;

import java.security.SecureRandom;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; // Added this import

import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.LoginDTO;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.Repos.UserRepo;
import com.fable.weatherall.Responses.LoginResponse;
import com.fable.weatherall.Services.UserService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service // Added annotation to indicate that this is a service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = userRepo.findByEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setConfirmpassword(passwordEncoder.encode(userDTO.getConfirmpassword()));
        user.setUserType(userDTO.getUserType());
        user.setOtp(userDTO.getOtp());
        userRepo.save(user);
        return user.getUsername();
    }
    
    @Override
    public List<String> addMultipleUsers(List<UserDTO> userDTOList) {
        List<String> addedUsernames = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            String username = addUser(userDTO);
            addedUsernames.add(username);
        }
        return addedUsernames;
    }
    
    @Override
    public String updateUser(int userId, UserDTO userDTO) {
        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            
            // Update user information
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            userRepo.save(existingUser);

            return existingUser.getUsername();
        } else {
            return "User not found";
        }
    }
    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public LoginResponse loginUser(LoginDTO loginDTO) {
        
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true); // Fixed syntax
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false); // Fixed typo
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
        
    }
    
 // Inside UserIMPL.java
  
//    public String generateOtp() {
//        Random random = new Random();
//        int otpNumber = 100000 + random.nextInt(900000);
//        return String.valueOf(otpNumber);
//    }

//    @Override
//    public void sendOtp(String email) {
//    	 User user = userRepo.findByEmail(email);
//         if (user != null) {
//             String otp = generateOtp();
//             user.setOtp(otp);
//             user.setOtpGeneratedTime(LocalDateTime.now());
//             userRepo.save(user);
//
//             // Use JavaMailSender to send an email with the OTP
//             SimpleMailMessage message = new SimpleMailMessage();
//             message.setTo(email);
//             message.setSubject("Your OTP for Fable WeatherAll");
//             message.setText("Your OTP is: " + otp);
//             javaMailSender.send(message);
//         }
//    }

//    @Override
//    public boolean verifyOtp(String email, String otp) {
//        User user = userRepo.findByEmail(email);
//        if (user != null && user.getOtp() != null && user.getOtp().equals(otp)) {
//            LocalDateTime otpGeneratedTime = user.getOtpGeneratedTime();
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            Duration duration = Duration.between(otpGeneratedTime, currentDateTime);
//            long minutesElapsed = duration.toMinutes();
//            // Set a time limit for OTP verification (e.g., 10 minutes)
//            if (minutesElapsed <= 10) {
//                user.setOtp(null);
//                user.setOtpGeneratedTime(null);
//                userRepo.save(user);
//                return true;
//            }
//        }
//        return false;
//    }

	public void sendOtpService(String email) {
		String otp=generateOtp();
		if (otp == null) {
            throw new RuntimeException("Failed to generate OTP");
        }
		User user = userRepo.findByEmail(email);
		if (user==null){
			 user=new User();
		}
		user.setEmail(email);
		//System.out.println(user.getEmail());
		user.setOtp(otp);
		userRepo.save(user);
		try {
			sendOtpToMail(email,otp);
			
		}catch(MessagingException e) {
			throw new RuntimeException("unable to send otp");
		}
		
	}
	public String generateOtp() {
		SecureRandom random=new SecureRandom();
		int otp= 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}
	private void sendOtpToMail(String email,String otp) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Your OTP is:");
		mimeMessageHelper.setText(otp);
		javaMailSender.send(mimeMessage);
				
	}


	public boolean verifyOtp(String email, String otp) {
		 User user = userRepo.findByEmail(email);
		 if (user.getOtp() .equals(otp))
		 {
			 return true;
		 }
		return false;
	}

}





