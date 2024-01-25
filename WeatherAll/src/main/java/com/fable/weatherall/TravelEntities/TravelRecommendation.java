package com.fable.weatherall.TravelEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "TravelRecommendation")
public class TravelRecommendation {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TravelRecommendationid")
    private Integer travelRecommendationid;

    @ManyToOne
    @JoinColumn(name = "Travelid", nullable = false)
    private TravelNames travelnames;

    @ManyToOne
    @JoinColumn(name = "weatherDescriptionId")
    private WeatherDescriptionTravel weatherDescription;

    @ManyToOne
    @JoinColumn(name = "recommendationLevelId")
    private RecommendationLevelTravel recommendationLevel;

	public Integer getTravelRecommendationid() {
		return travelRecommendationid;
	}

	public void setTravelRecommendationid(Integer travelRecommendationid) {
		this.travelRecommendationid = travelRecommendationid;
	}

	public TravelNames getTravelnames() {
		return travelnames;
	}

	public void setTravelnames(TravelNames travelnames) {
		this.travelnames = travelnames;
	}

	public WeatherDescriptionTravel getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(WeatherDescriptionTravel weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public RecommendationLevelTravel getRecommendationLevel() {
		return recommendationLevel;
	}

	public void setRecommendationLevel(RecommendationLevelTravel recommendationLevel) {
		this.recommendationLevel = recommendationLevel;
	}
    
    

}
