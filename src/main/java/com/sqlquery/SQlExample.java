package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;


public class SQlExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		String query = "select * from Student";
		
	NativeQuery creNativeQuery = session.createSQLQuery(query);
	List<Object[]> list = creNativeQuery.list();
	for (Object[] student : list) {
		System.out.println(Arrays.toString(student));
	}
	
		factory.close();
		session.close();
	}

}
