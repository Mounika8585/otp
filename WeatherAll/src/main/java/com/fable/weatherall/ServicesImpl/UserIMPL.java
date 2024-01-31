package com.fable.weatherall.ServicesImpl;

import java.security.SecureRandom;



import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; // Added this import
import org.springframework.ui.Model;

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
    public String addUser(User user) {
        User saved = userRepo.findByEmail(user.getEmail());
        if (saved == null) {
        	saved = new User();  // Add this line to create a new User object
        }
        if(!saved.getOtp().equals(user.getOtp()))
        	return "Otp not matched";
        saved.setUsername(user.getUsername());
        saved.setEmail(user.getEmail());
        saved.setPassword(passwordEncoder.encode(user.getPassword()));
        saved.setConfirmpassword(passwordEncoder.encode(user.getConfirmpassword()));
        saved.setUserType(user.getUserType());
        saved.setOtp(user.getOtp());
        
        userRepo.save(saved);
        return user.getUsername();
    }
    
    @Override
    public List<String> addMultipleUsers(List<User> userList) {
        List<String> addedUsernames = new ArrayList<>();
        for (User user : userList) {
            String username = addUser(user);
            addedUsernames.add(username);
        }
        return addedUsernames;
    }
    
    @Override
    public String updateUser(int userId, User user) {
        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            
            // Update user information
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

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

	@Override
	public int resetPassword(User user) {
		User user1 = userRepo.findByEmail(user.getEmail());
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if (user1==null) {
			return 1;
		}
		 if (user1.getOtp() .equals(user.getOtp())){
			 String password=encoder.encode(user.getPassword());
			 user1.setPassword(password);
			 userRepo.save(user1);
			 return 2;
		 }
		 return 3;
		 
	}
	
}





