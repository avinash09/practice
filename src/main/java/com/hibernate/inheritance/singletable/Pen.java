package com.hibernate.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pen")
public class Pen extends MyProduct {

	private String color;

	public Pen(Integer productId, String name, String color) {
		super(productId, name);
		this.color = color;
	}

	public Pen() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pen [color=" + color + "] "+super.toString();
	}

}
