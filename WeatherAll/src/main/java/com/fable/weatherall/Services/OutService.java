package com.fable.weatherall.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fable.weatherall.Repos.OutRepo;
import com.fable.weatherall.Repos.OutRepo.ActivityRecommendationProjection;

@Service 
public class OutService {

	@Autowired
	private OutRepo repo;
	
	public List<ActivityRecommendationProjection> getActivities(String description) {
		
        return repo.findByWeatherDescriptionDescription(description);
        
    }
}
