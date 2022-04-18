package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestHibernate {

	public static void main(String[] args) {
		//add();
		//persist();
		//update();
		//merge();
		//delete();
		//get();
		load();
		
	}

	private static void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			// Add new Employee object
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmail("demo-user10@mail.com");
			emp.setFirstName("demo");
			emp.setLastName("user");

			int i = (int) session.save(emp);
			emp.setFirstName("Avinash");
			tx.commit();
			emp.setFirstName("Vikrant");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	private static void persist() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity emp = new EmployeeEntity();
		try {
			// Add new Employee object
			
			emp.setEmail("demo-user9@mail.com");
			emp.setFirstName("demo");
			emp.setLastName("user");

			session.persist(emp);
			emp.setFirstName("Avinash");
			tx.commit();
			emp.setFirstName("Vikrant");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			emp.setFirstName("Pallavi");
			HibernateUtil.shutdown();
		}
		
	}
	
	private static void update() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity emp = new EmployeeEntity();
		try {
			// Add new Employee object
			
			emp.setEmployeeId(1);
			emp.setEmail("demo-user@mail.com");
			emp.setFirstName("demo05");
			emp.setLastName("user");
			
			session.saveOrUpdate(emp);
			
			emp.setFirstName("demo03");
			tx.commit();
			emp.setFirstName("demo04");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			emp.setFirstName("demo05");
			HibernateUtil.shutdown();
		}
	}
	
	private static void merge() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity emp = new EmployeeEntity();
		try {
			// Add new Employee object
			
			emp.setEmployeeId(1);
			emp.setEmail("demo-user@mail.com");
			emp.setFirstName("demo00");
			emp.setLastName("user");
			
			session.update(emp);
			session.close();
			
			emp.setFirstName("demo01");
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			Transaction tx2 = session2.beginTransaction();
			EmployeeEntity emp2 =session2.get(EmployeeEntity.class, 1);
			emp2.setFirstName("demo02");
			
			//session2.update(emp);
			session2.merge(emp);
			
			tx2.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	private static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			// delete Employee object
			
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmployeeId(3);
			emp.setEmail("demo-user4@mail.com");
			emp.setFirstName("demo");
			emp.setLastName("user");

			session.delete(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	public static void get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		EmployeeEntity emp= session.get(EmployeeEntity.class, 4);
		System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	public static void load() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		EmployeeEntity emp= session.load(EmployeeEntity.class, 4);
		System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

}
