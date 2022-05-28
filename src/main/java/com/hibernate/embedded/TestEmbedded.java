package com.hibernate.embedded;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;

public class TestEmbedded {

	public static void main(String[] args) {
		getById();

	}
	
	private static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			Student student = new Student("Eswar", address);
			session.save(student);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private static void getById() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Student student = session.get(Student.class, 1l);
			System.out.println(student);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
