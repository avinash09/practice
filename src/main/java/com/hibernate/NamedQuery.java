package com.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class NamedQuery {

	public static void main(String[] args) {

		//getNamedQuery();
		getNamedQueryNative();
	}

	/* Get HQL named Query */
	public static void getNamedQuery() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createNamedQuery("findEmpById");
			query.setParameter("employeeId", 1);
			List<EmployeeEntity> list = query.list();

			list.forEach(n -> System.out.println(n.toString()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// HibernateUtil.shutdown();
		}
	}
	
	/* Get HQL named Query */
	public static void getNamedQueryNative() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createNamedQuery("findEmpByIdNativeSQL");
			query.setParameter("employeeId", 1);
			List<EmployeeEntity> list = query.list();

			list.forEach(n -> System.out.println(n.toString()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// HibernateUtil.shutdown();
		}
	}
}
