package com.fable.weatherall.DB_Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fable.weatherall.FoodEntites.Food;
import com.fable.weatherall.Services.FoodService;

@RestController
public class FoodController {

	@Autowired
	private FoodService service;
	
	@GetMapping("/getfoods/{state}/{temperature}")
    public List<Food> getfoods(
    		@PathVariable("state") String state,
    		@PathVariable("temperature") Double temperature) {
		System.out.println(state+temperature);
        return service.getFoods(state, temperature);
    }
}