package com.fable.weatherall.DB_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.Repos.ClothRepo.ClothingRecommendationProjection;
import com.fable.weatherall.Services.ClothService;


@RestController
public class ClothController {

    @Autowired
    private ClothService clothService;

    @GetMapping("/clothing/{description}")
    public List<ClothingRecommendationProjection> getClothingRecommendations(@PathVariable String description) {
    	
        return clothService.getCloths(description);
    }
    
}
