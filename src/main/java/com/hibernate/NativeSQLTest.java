package com.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class NativeSQLTest {

	public static void main(String[] args) {
		//listEmpObjArr();
		//listEmployeesScalarMap();
		//listEmployeesEntity( );
		listEmployeesEntityNamed();
	}

	public static void listEmpObjArr() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select * from Employee");
			List<Object[]> list = sqlQuery.list();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				System.out.println(object[0] + " " + object[1] + " " + object[2] + " " + object[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//HibernateUtil.shutdown();
		}
	}
	
	/* Method to  READ all the employees using Scalar Query */
	public static void listEmployeesScalarMap() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select * from Employee");
			sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List list = sqlQuery.list();
			
			for(Object object:list) {
				Map map = (Map)object;
				System.out.println(map.get("ID") +" "+map.get("EMAIL")+" "+map.get("SALARY"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//HibernateUtil.shutdown();
		}
	}
	
	/* Method to READ all the employees using Entity Query */
	   public static void listEmployeesEntity( ){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select * from Employee");
			sqlQuery.addEntity(EmployeeEntity.class);
			List list = sqlQuery.list();
			
			for(Object object:list) {
				EmployeeEntity employee  = (EmployeeEntity)object;
				System.out.println(employee.toString());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//HibernateUtil.shutdown();
		}
	}
	
	   /* Method to READ all the employees using Entity Query Named */
	   public static void listEmployeesEntityNamed( ){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select * from Employee where ID=:id");
			sqlQuery.addEntity(EmployeeEntity.class);
			sqlQuery.setParameter("id", 1);
			List list = sqlQuery.list();
			
			for(Object object:list) {
				EmployeeEntity employee  = (EmployeeEntity)object;
				System.out.println(employee.toString());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//HibernateUtil.shutdown();
		}
	}

}
