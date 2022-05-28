package com.hibernate.inheritance.singletable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;

public class HibernateSingleTableTest {

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
			MyProduct myProduct = new MyProduct(null,"MyProduct");
			
			Book book = new Book(null, "book", "KJ");
			
			Pen pen = new Pen(null, "Pen", "LL");

			session.save(myProduct);
			session.save(book);
			session.save(pen);
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
		MyProduct myProduct= session.get(MyProduct.class, 1);
		MyProduct book= session.get(Book.class, 2);
		MyProduct pen= session.get(Pen.class, 3);
		
		System.out.println(myProduct);
		System.out.println(book);
		System.out.println(pen);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

}
