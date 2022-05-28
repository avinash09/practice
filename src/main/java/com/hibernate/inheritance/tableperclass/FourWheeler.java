package com.hibernate.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FOUR_WHEELER")
public class FourWheeler extends Vehicle {
	@Column(name = "STEERING_TYPE")
	private String steeringFourWheeler;

	public FourWheeler(Integer vehicleId, String vehicleName, String steeringFourWheeler) {
		super(vehicleId, vehicleName);
		this.steeringFourWheeler = steeringFourWheeler;
	}

	public FourWheeler() {
		super();
	}

	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}

	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}

	@Override
	public String toString() {
		return "FourWheeler [steeringFourWheeler=" + steeringFourWheeler + ", toString()=" + super.toString() + "]";
	}

}
