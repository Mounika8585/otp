package com.fable.weatherall.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fable.weatherall.ClothEntites.ClothingRecommendation;



public interface ClothRepo extends JpaRepository<ClothingRecommendation, Integer> {

	public interface ClothingRecommendationProjection {
		
	    String getItemName();
        String getTypeName();
	}

	@Query("SELECT ci.itemName as itemName, ct.typeName as typeName	" +
	       "FROM ClothingRecommendation cr " +
	       "JOIN cr.weatherDescription wd " +
	       "JOIN cr.clothingType ct " +
	       "JOIN cr.clothingItem ci " +
	       "WHERE wd.description = :description")
	List<ClothingRecommendationProjection> findByWeatherDescriptionDescription(@Param("description") String description);


}
