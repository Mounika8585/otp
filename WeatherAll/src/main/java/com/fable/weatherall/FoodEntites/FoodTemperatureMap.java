package com.fable.weatherall.FoodEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "FoodTemperatureMap")
public class FoodTemperatureMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodTemperatureId")
    private Integer foodTemperatureId;

    @ManyToOne
    @JoinColumn(name = "foodId", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private TemperatureCategory temperatureCategory;

	public Integer getFoodTemperatureId() {
		return foodTemperatureId;
	}

	public void setFoodTemperatureId(Integer foodTemperatureId) {
		this.foodTemperatureId = foodTemperatureId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public TemperatureCategory getTemperatureCategory() {
		return temperatureCategory;
	}

	public void setTemperatureCategory(TemperatureCategory temperatureCategory) {
		this.temperatureCategory = temperatureCategory;
	}

    
}

