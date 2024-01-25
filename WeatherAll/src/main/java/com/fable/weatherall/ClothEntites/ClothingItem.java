package com.fable.weatherall.ClothEntites;

import jakarta.persistence.*;

@Entity
@Table(name = "ClothingItem")
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothingItemId")
    private Integer clothingItemId;

    @Column(name = "itemName", nullable = false)
    private String itemName;


    public Integer getClothingItemId() {
        return clothingItemId;
    }

    public void setClothingItemId(Integer clothingItemId) {
        this.clothingItemId = clothingItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}

