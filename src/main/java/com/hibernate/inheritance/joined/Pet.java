package com.hibernate.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "petid")
public class Pet extends Animal {

	private String name;

	public Pet(Integer animalId, String species, String name) {
		super(animalId, species);
		this.name = name;
	}

	public Pet() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + "] "+super.toString();
	}

}
