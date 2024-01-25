package com.fable.weatherall.ClothEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "ClothingRecommendation")
public class ClothingRecommendation {
	
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothingRecommendationId")
	    private Integer clothingRecommendationId;

	    @ManyToOne
	    @JoinColumn(name = "weatherDescriptionId", nullable = false)
	    private WeatherDescription weatherDescription;

	    @ManyToOne
	    @JoinColumn(name = "clothingTypeId", nullable = false)
	    private ClothingType clothingType;

	    @ManyToOne
	    @JoinColumn(name = "clothingItemId", nullable = false)
	    private ClothingItem clothingItem;

	    
    public Integer getClothingRecommendationId() {
        return clothingRecommendationId;
    }

    public void setClothingRecommendationId(Integer clothingRecommendationId) {
        this.clothingRecommendationId = clothingRecommendationId;
    }

    public WeatherDescription getWeatherDescriptionId() {
        return weatherDescription;
    }

    public void setWeatherDescriptionId(WeatherDescription weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public ClothingType getClothingTypeId() {
        return clothingType;
    }

    public void setClothingTypeId(ClothingType clothingType) {
        this.clothingType = clothingType;
    }

    public ClothingItem getClothingItemId() {
        return clothingItem;
    }

    public void setClothingItemId(ClothingItem clothingItem) {
        this.clothingItem = clothingItem;
    }

}