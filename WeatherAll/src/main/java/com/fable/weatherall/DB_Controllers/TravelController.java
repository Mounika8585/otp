package com.fable.weatherall.DB_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Repos.TravelRepo.TravelRecommendationProjection;
import com.fable.weatherall.Services.TravelService;

@RestController
public class TravelController {
	
	    @Autowired
	    private TravelService travelService;

	    @GetMapping("/travel/{description}")
	    public List<TravelRecommendationProjection> getActivityRecommendations(@PathVariable String description) {
	    	
	    	 return travelService.getActivities(description);
	    }
}
