package com.hibernate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get();
		// pagination();
		// orderBy();
		// restrictionsCluse();
		 projections();
		// unique result
	}

	private static void get() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria criteria = session.createCriteria(EmployeeEntity.class);
			List<EmployeeEntity> list = criteria.list();
			System.out.println("Result:- " + list);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}

	}

	private static void pagination() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria criteria = session.createCriteria(EmployeeEntity.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(1);

			List<EmployeeEntity> list = criteria.list();
			System.out.println("Result:- " + list);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}

	}

	private static void orderBy() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria criteria = session.createCriteria(EmployeeEntity.class);
			criteria.addOrder(Order.asc("employeeId"));

			List<EmployeeEntity> list = criteria.list();
			System.out.println("Result:- " + list);

			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.addOrder(Order.desc("employeeId"));
			list = criteria.list();
			System.out.println("Result:- " + list);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
	
	private static void restrictionsCluse() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			// To get records having id equal to 1
			Criteria criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.eq("employeeId", 1));
			List<EmployeeEntity> list = criteria.list();
			System.out.println("equal:-"+list);
			
			// To get records having salary more than 10000
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.gt("salary", 10000l));
			list = criteria.list();
			System.out.println("salary more than:-"+list);
			
			// To get records having salary less than 10000
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.lt("salary", 10000l));
			list = criteria.list();
			System.out.println("salary less than:-"+list);
			
			// To get records having last name like than lonkar
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.like("lastName", "Lonkar%"));
			list = criteria.list();
			System.out.println("last name like:-"+list);
			
			// Case sensitive form of the above restriction.
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.ilike("lastName", "lonkar%"));
			list = criteria.list();
			System.out.println("last name like canse sensitive:-"+list);
			
			//To get records having salary between 10000 and 40000
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.between("salary", 10000l, 40000l));
			list = criteria.list();
			System.out.println("salary between:-"+list);
			
			//To get records having empty email  isEmpty used for list field only
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.eq("email",""));
			list = criteria.list();
			System.out.println("empty email:-"+list);
			
			//To get records having null salary
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.isNull("salary"));
			list= criteria.list();
			System.out.println("null Salary:-"+list);
			
			//To get records having not null salary
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.isNotNull("salary"));
			list = criteria.list();
			System.out.println("salary not null:-"+list);
			
			//To get records having salary more then 10000 or last name like 
			criteria = session.createCriteria(EmployeeEntity.class);
			Criterion salary= Restrictions.gt("salary", 10000l);
			Criterion lastName= Restrictions.eq("lastName", "Lonkar");
			
			LogicalExpression orl = Restrictions.or(salary, lastName);
			criteria.add(orl);
			criteria.list();
			list = criteria.list();
			System.out.println("OR Results:-"+list);
			
			
			criteria = session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.and(salary,lastName));
			criteria.list();
			list = criteria.list();
			System.out.println("AND Results:-"+list);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
	
	public static void projections() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	    //To get records with first name
		Criteria criteria = session.createCriteria(EmployeeEntity.class);
		criteria.setProjection(Projections.property("firstName"));
		List list = criteria.list();
		System.out.println("result:- "+list);
		
		//To get records with firstName,Salary and Email
		criteria = session.createCriteria(EmployeeEntity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("firstName"));
		projectionList.add(Projections.property("salary"));
		projectionList.add(Projections.property("email"));
		criteria.setProjection(projectionList);
		List<Object[]> emplist = criteria.list();
		emplist.stream().forEach(n->System.out.println(Arrays.toString(n)));
		
		//To get aggregate function data
		criteria=session.createCriteria(EmployeeEntity.class);
		projectionList = Projections.projectionList();
		projectionList.add(Projections.avg("salary"));
		projectionList.add(Projections.sum("salary"));
		projectionList.add(Projections.max("salary"));
		projectionList.add(Projections.min("salary"));
		projectionList.add(Projections.rowCount());
		
		criteria.setProjection(projectionList);
		List<Object[]> emlist = criteria.list();
		emlist.stream().forEach(n->System.out.println(Arrays.toString(n)));
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			HibernateUtil.shutdown();
		}
		
	}
}
