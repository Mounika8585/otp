package com.fable.weatherall.ClothEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "WeatherDescription")
public class WeatherDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weatherDescriptionId")
    private Integer weatherDescriptionId;
    
    @Column(name = "description", nullable = false)
    private String description;

    // Getters and setters
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
