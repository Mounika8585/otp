package com.fable.weatherall.OutEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ActivityRecommendation")
public class ActivityRecommendation {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActivityRecommendationid")
    private Integer activityRecommendationid;

    @ManyToOne
    @JoinColumn(name = "Activityid", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "weatherDescriptionId")
    private WeatherDescriptionOut weatherDescription;

    @ManyToOne
    @JoinColumn(name = "recommendationLevelId")
    private RecommendationLevelOut recommendationLevel;

	public Integer getActivityRecommendationid() {
		return activityRecommendationid;
	}

	public void setActivityRecommendationid(Integer activityRecommendationid) {
		this.activityRecommendationid = activityRecommendationid;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public WeatherDescriptionOut getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(WeatherDescriptionOut weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public RecommendationLevelOut getRecommendationLevel() {
		return recommendationLevel;
	}

	public void setRecommendationLevel(RecommendationLevelOut recommendationLevel) {
		this.recommendationLevel = recommendationLevel;
	}

    
}
