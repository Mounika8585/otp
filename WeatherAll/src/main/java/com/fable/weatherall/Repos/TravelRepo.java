package com.fable.weatherall.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fable.weatherall.TravelEntities.TravelRecommendation;


public interface TravelRepo extends JpaRepository<TravelRecommendation, Integer> {
	
public interface TravelRecommendationProjection {
		
        String getTravelname();
        String getLevel();
    }

    @Query("SELECT tn.Travelname as travelname, rlo.level as level " +
           "FROM TravelRecommendation tr " +
           "JOIN tr.travelnames tn " +
           "JOIN tr.recommendationLevel rlo " +
           "JOIN tr.weatherDescription wd " +
           "WHERE wd.description = :description")
    List<TravelRecommendationProjection> findByWeatherDescriptionDescription(@Param("description") String description);

}
