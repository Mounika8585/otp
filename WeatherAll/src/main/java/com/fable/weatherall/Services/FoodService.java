package com.fable.weatherall.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fable.weatherall.FoodEntites.Food;
import com.fable.weatherall.Repos.FoodRepo;

@Service
public class FoodService {

	@Autowired
	private FoodRepo repo;

	public List<Food> getFoods(String state, Double temperature) {
        // Find the category ID based on the input temperature
        Integer categoryId = repo.findCategoryIdByTemperature(temperature);

//        if (categoryId != null) {
//        	// Retrieve the foods that match the state and obtained category ID
//            return repo.findByStateAndCategoryId(state, categoryId);
//        } else {
//            // Handle the case where no category ID is found for the given temperature
//            return null;
    
        return repo.findByStateAndCategoryId(state, categoryId);
        
    }
}
