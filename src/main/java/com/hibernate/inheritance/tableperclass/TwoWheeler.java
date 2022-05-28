package com.hibernate.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TWO_WHEELER")
public class TwoWheeler extends Vehicle {
	@Column(name = "STEERING_TYPE")
	private String steeringTwoWheeler;

	public TwoWheeler(Integer vehicleId, String vehicleName, String steeringTwoWheeler) {
		super(vehicleId, vehicleName);
		this.steeringTwoWheeler = steeringTwoWheeler;
	}

	public TwoWheeler() {
		super();
	}

	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}

	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}

	@Override
	public String toString() {
		return "TwoWheeler [steeringTwoWheeler=" + steeringTwoWheeler + ", toString()=" + super.toString() + "]";
	}

}
