package com.fable.weatherall.DB_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Repos.OutRepo.ActivityRecommendationProjection;
import com.fable.weatherall.Services.OutService;

@RestController
public class OutActivityController {

	    @Autowired
	    private OutService outService;

	    @GetMapping("/outdoor/{description}")
	    public List<ActivityRecommendationProjection> getActivityRecommendations(@PathVariable String description) {
	    	
	    	 return outService.getActivities(description);
	    }
	
}
