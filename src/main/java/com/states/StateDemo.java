package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernateProject.Certificate;
import com.hibernateProject.Student1;

public class StateDemo {

	public static void main(String[] args) {
		System.out.println("Example :");

		SessionFactory factory = new Configuration().configure("com/hibernateProject/hibernate.cfg.xml").buildSessionFactory();

		// Creating student
		Student1 student = new Student1();
		student.setId(1212);
		student.setName("Sameer");
		student.setCity("Mumbai");
		student.setCertificate(new Certificate("Java hibernate course ", "2 month"));

		// student : trasient state

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(student);

		// persistent state because this object point session and database

		transaction.commit();
		factory.close();
	}
}
