package com.fable.weatherall.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.fable.weatherall.Admin_User_Entities.User;



@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	//changes
	User findByUsername(String username);

	Optional<User> findOneByEmailAndPassword(String username, String password);
	User findByOtp(String otp);

}
