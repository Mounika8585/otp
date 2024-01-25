package com.fable.weatherall.OutEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "RecommendationLevelOut")
public class RecommendationLevelOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommendationLevelId")
    private Integer recommendationLevelId;

    @Column(name = "level", nullable = false)
    private String level;


    public Integer getRecommendationLevelId() {
        return recommendationLevelId;
    }

    public void setRecommendationLevelId(Integer recommendationLevelId) {
        this.recommendationLevelId = recommendationLevelId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
}
