package com.fable.weatherall.FoodEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodId")
    private Integer foodId;

    @Column(name = "foodName", nullable = false)
    private String foodName;

    @Column(name = "state", nullable = false)
    private String state;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

   

}

