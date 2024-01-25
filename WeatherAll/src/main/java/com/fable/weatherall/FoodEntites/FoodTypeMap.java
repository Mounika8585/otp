package com.fable.weatherall.FoodEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "FoodTypeMap")
public class FoodTypeMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodTypeId")
    private Integer foodTypeId;

    @ManyToOne
    @JoinColumn(name = "foodId", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private Type type;

	public Integer getFoodTypeId() {
		return foodTypeId;
	}

	public void setFoodTypeId(Integer foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

   

}

