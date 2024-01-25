package com.fable.weatherall.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fable.weatherall.OutEntities.ActivityRecommendation;



public interface OutRepo extends JpaRepository<ActivityRecommendation, Integer> {
	
	public interface ActivityRecommendationProjection {
		
        String getActivityname();
        String getLevel();
    }

    @Query("SELECT a.Activityname as activityname, rlo.level as level " +
           "FROM ActivityRecommendation ar " +
           "JOIN ar.activity a " +
           "JOIN ar.recommendationLevel rlo " +
           "JOIN ar.weatherDescription wd " +
           "WHERE wd.description = :description")
    List<ActivityRecommendationProjection> findByWeatherDescriptionDescription(@Param("description") String description);


}
