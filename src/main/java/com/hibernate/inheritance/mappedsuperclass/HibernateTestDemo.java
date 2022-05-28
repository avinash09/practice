package com.hibernate.inheritance.mappedsuperclass;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.EmployeeEntity;
import com.hibernate.HibernateUtil;

public class HibernateTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//mappedSuperClass();
		getObjectById();
	}

	public static void mappedSuperClass() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			// Add new Employee object
			MyEmployee myEmployee = new MyEmployee();
			myEmployee.setPersonId(12l);
			myEmployee.setName("Avinash");
			myEmployee.setCompany("Mastek");

			session.save(myEmployee);
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
		MyEmployee myEmployee= session.get(MyEmployee.class, 12l);
		System.out.println(myEmployee);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

}
