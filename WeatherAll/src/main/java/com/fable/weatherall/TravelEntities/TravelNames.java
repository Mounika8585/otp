package com.fable.weatherall.TravelEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "TravelNames")
public class TravelNames {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Travelid")
    private Integer Travelid;
    
    @Column(name = "Travelname", nullable = false)
    private String Travelname;

	public Integer getTravelid() {
		return Travelid;
	}

	public void setTravelid(Integer travelid) {
		Travelid = travelid;
	}

	public String getTravelname() {
		return Travelname;
	}

	public void setTravelname(String travelname) {
		Travelname = travelname;
	}
	
}
