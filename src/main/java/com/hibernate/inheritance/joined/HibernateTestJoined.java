package com.hibernate.inheritance.joined;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;

public class HibernateTestJoined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//saveObject();
		getObjectById();
	}

	public static void saveObject() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			// Add new Employee object
			Animal animal = new Animal(null,"Animal");
			
			Pet pet = new Pet(null, "Pet", "KJ");

			session.save(animal);
			session.save(pet);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	public static void getObjectById() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Animal animal= session.get(Animal.class, 1);
		Pet pet = session.get(Pet.class, 2);
		
		System.out.println(animal);
		System.out.println(pet);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}



}
