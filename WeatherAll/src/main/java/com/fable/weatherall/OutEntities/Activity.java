package com.fable.weatherall.OutEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Activityid")
	    private Integer Activityid;
	    
	    @Column(name = "Activityname", nullable = false)
	    private String Activityname;

		public Integer getActivityid() {
			return Activityid;
		}

		public void setActivityid(Integer activityid) {
			Activityid = activityid;
		}

		public String getActivityname() {
			return Activityname;
		}

		public void setActivityname(String activityname) {
			Activityname = activityname;
		}

}
