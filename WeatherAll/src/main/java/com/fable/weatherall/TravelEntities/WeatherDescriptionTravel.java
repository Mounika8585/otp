package com.fable.weatherall.TravelEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "WeatherDescriptionTravel")
public class WeatherDescriptionTravel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weatherDescriptionId")
    private Integer weatherDescriptionId;
    
    @Column(name = "description", nullable = false)
    private String description;

	public Integer getWeatherDescriptionId() {
		return weatherDescriptionId;
	}

	public void setWeatherDescriptionId(Integer weatherDescriptionId) {
		this.weatherDescriptionId = weatherDescriptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
