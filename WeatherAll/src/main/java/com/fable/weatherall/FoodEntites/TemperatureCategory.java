package com.fable.weatherall.FoodEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "TemperatureCategory")
public class TemperatureCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "categoryName", nullable = false)
    private String categoryName;

    @Column(name = "minTemperature", nullable = false)
    private Double minTemperature;

    @Column(name = "maxTemperature", nullable = false)
    private Double maxTemperature;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

    

}

