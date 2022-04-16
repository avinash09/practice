package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestHibernate {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
        
		try {
		  //Add new Employee object 
		  EmployeeEntity emp = new EmployeeEntity();
		  emp.setEmail("demo-user4@mail.com"); emp.setFirstName("demo");
		  emp.setLastName("user");
		  
		  session.save(emp);
		  if(1==1)
		  throw new NullPointerException();
		  tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtil.shutdown();
		}
		try {
		/*EmployeeEntity emp = session.get(EmployeeEntity.class, 1);
		System.out.println(emp);
		Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where firstName=:firstName");
		query.setParameter("firstName", "demo");
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List<EmployeeEntity> list = query.list();
		list.forEach(n->System.out.print(n));*/
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			HibernateUtil.shutdown();
		}
		
	}

}
