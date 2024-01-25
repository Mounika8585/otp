package com.fable.weatherall.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fable.weatherall.Repos.TravelRepo;
import com.fable.weatherall.Repos.TravelRepo.TravelRecommendationProjection;


@Service
public class TravelService {
	
	
	@Autowired
	private TravelRepo repo;

     public List<TravelRecommendationProjection> getActivities(String description) {
		
        return repo.findByWeatherDescriptionDescription(description);
        
    }

}
