package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernateProject.Student;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		
		Student student2 = session.get(Student.class, 101);
		System.out.println(session.contains(student2));
//		Transaction transaction = session.beginTransaction();
//		transaction.commit();
		session.close();
	}

}
