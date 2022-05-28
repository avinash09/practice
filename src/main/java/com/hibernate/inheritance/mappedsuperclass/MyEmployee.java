package com.hibernate.inheritance.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class MyEmployee extends Person {

	private String company;

	public MyEmployee(String company,Long personId, String name) {
		super(personId,name);
		this.company = company;
	}

	public MyEmployee() {
		super();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "MyEmployee [company=" + company + "]"+"Person [personId=" + super.getPersonId() + ", name=" + super.getName() + "]";
	}

}
