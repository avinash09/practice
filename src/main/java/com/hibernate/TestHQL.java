package com.hibernate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHQL {

	public static void main(String[] args) {
		// get();
		// select();
		// whereClause();
		// orderByClause();
		// groupByClause();
		// aggregate();
		// insertClause();
		// updateClause();
		// deleteClause();
		//pagination();
	}

	public static void get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity E");
			List<EmployeeEntity> emplist = query.list();
			System.out.println(emplist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void select() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<EmployeeEntity> query = session.createQuery("select E.firstName from EmployeeEntity E");
			List<EmployeeEntity> emplist = query.list();
			System.out.println("Result:-" + emplist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void whereClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity E where E.email=:email");
			query.setParameter("email", "demo-user0.8325301445304603@mail.com");
			List<EmployeeEntity> emplist = query.list();
			System.out.println("Result:-" + emplist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void orderByClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity E order by E.employeeId desc");
			List<EmployeeEntity> emplist = query.list();
			System.out.println("Result:-" + emplist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void groupByClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<Object[]> query = session
					.createQuery("select sum(E.salary),E.firstName from EmployeeEntity E group by E.firstName");
			List<Object[]> emplist = query.list();
			for (Iterator iterator = emplist.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
				System.out.println("Result:-" + Arrays.deepToString(objects));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void aggregate() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<Object[]> query = session
					.createQuery("select sum(E.salary),avg(E.salary),count(E.salary),max(E.salary),min(E.salary)"
							+ "from EmployeeEntity E");
			List<Object[]> emplist = query.list();
			for (Iterator iterator = emplist.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
				System.out.println("Result:-" + Arrays.deepToString(objects));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void pagination() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity");
			query.setFirstResult(0);
			query.setMaxResults(7);

			List<EmployeeEntity> emplist = query.list();
			System.out.println("Result:-");
			emplist.stream().forEach(n -> System.out.println(n));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}

	public static void insertClause() {
		// insert not allowed values(). we can insert through only select
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("insert into EmployeeEntity(email,firstName,lastName,salary)"
					+ " select email,firstName,lastName,salary from EmployeeEntity");

			int count = query.executeUpdate();
			System.out.println("Result:- " + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void updateClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("update EmployeeEntity set salary=:salary where firstName=:firstName");

			query.setParameter("salary", 63000l);
			query.setParameter("firstName", "Avinash");

			int count = query.executeUpdate();
			tx.commit();

			System.out.println("Result:- " + count);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void deleteClause() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("delete EmployeeEntity where firstName=:firstName");
			query.setParameter("firstName", "Vikrant");

			int count = query.executeUpdate();
			tx.commit();

			System.out.println("Result:- " + count);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
