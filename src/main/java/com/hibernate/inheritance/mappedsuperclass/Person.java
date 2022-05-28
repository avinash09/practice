package com.hibernate.inheritance.mappedsuperclass;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

	@Id
	private Long personId;

	private String name;

	public Person() {
		super();
	}

	public Person(Long personId, String name) {
		super();
		this.personId = personId;
		this.name = name;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}
	
	
}
