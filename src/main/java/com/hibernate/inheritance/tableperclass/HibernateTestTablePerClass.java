package com.hibernate.inheritance.tableperclass;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;

public class HibernateTestTablePerClass {

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
			Vehicle vehicle = new Vehicle(0, "Vehicle");

			TwoWheeler twoWheeler = new TwoWheeler(null, "TwoWheeler", "KJ");

			FourWheeler fourWheeler = new FourWheeler(null, "FourWheeler", "LL");

			session.save(vehicle);
			session.save(twoWheeler);
			session.save(fourWheeler);
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
		Vehicle vehicle = session.get(Vehicle.class, 2);
		TwoWheeler twoWheeler = session.get(TwoWheeler.class, 3);
		FourWheeler fourWheeler = session.get(FourWheeler.class, 4);

		System.out.println(vehicle);
		System.out.println(twoWheeler);
		System.out.println(fourWheeler);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

}
