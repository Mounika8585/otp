package com.fable.weatherall.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fable.weatherall.Repos.ClothRepo;
import com.fable.weatherall.Repos.ClothRepo.ClothingRecommendationProjection;


@Service
public class ClothService {
	
	@Autowired
	private ClothRepo repo;
	
	 public List<ClothingRecommendationProjection> getCloths(String description) {
		 
	        return repo.findByWeatherDescriptionDescription(description);
	    }

}