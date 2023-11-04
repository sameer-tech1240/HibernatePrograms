package com.hibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Student1_Certificate_App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate_project/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		
		Student1 student = new Student1();
		student.setName("Sameer");
		student.setCity("Mumbai");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("BCA");
		certificate.setDuration("3 Years");
		student.setCertificate(certificate);
		
		
		Student1 student1 = new Student1();
		student1.setName("Aadil Noor");
		student1.setCity("Mumbai");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("BCA");
		certificate1.setDuration("3 Years");
		student1.setCertificate(certificate1);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
	    session.persist(student);
	    session.persist(student1);
		transaction.commit();
		session.close();
		factory.close();
	}

}
