package com.fable.weatherall.ClothEntites;
import jakarta.persistence.*;

@Entity
@Table(name = "ClothingType")
public class ClothingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothingTypeId")
    private Integer clothingTypeId;

    @Column(name = "typeName", nullable = false)
    private String typeName;

    // Getters and Setters
    public Integer getClothingTypeId() {
        return clothingTypeId;
    }

    public void setClothingTypeId(Integer clothingTypeId) {
        this.clothingTypeId = clothingTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
  
    
}
