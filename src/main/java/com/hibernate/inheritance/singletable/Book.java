package com.hibernate.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "book")
public class Book extends MyProduct {
	private String author;

	public Book(Integer productId, String name, String author) {
		super(productId, name);
		this.author = author;
	}

	public Book(Integer productId, String name) {
		super(productId, name);
	}

	public Book() {
		super();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + "] "+super.toString();
	}
	
	
}
