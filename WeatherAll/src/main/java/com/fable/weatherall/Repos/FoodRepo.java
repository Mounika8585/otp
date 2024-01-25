package com.fable.weatherall.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fable.weatherall.FoodEntites.Food;


public interface FoodRepo extends JpaRepository<Food, Integer> {

    @Query("SELECT tc.categoryId " +
           "FROM TemperatureCategory tc " +
           "WHERE :temperature BETWEEN tc.minTemperature AND tc.maxTemperature")
    Integer findCategoryIdByTemperature(@Param("temperature") Double temperature);

	@Query("SELECT ftm.food " +
		       "FROM FoodTemperatureMap ftm " +
		       "WHERE ftm.food.state = :state AND ftm.temperatureCategory.categoryId = :categoryId")
     List<Food> findByStateAndCategoryId(@Param("state") String state, @Param("categoryId") Integer categoryId);
    
    
}