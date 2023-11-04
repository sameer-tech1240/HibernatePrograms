package com.hibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch_Data {
	public static void main(String[] args) {
		System.out.println("project started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		@SuppressWarnings("deprecation")
//		Student student = (Student) session.load(Student.class, 1);
//		@SuppressWarnings("deprecation")
//		Student student1 = (Student) session.load(Student.class, 52);
//		@SuppressWarnings("deprecation")
//		Student student2 = (Student) session.load(Student.class, 102);
//		System.out.println(student);
//		System.out.println(student1);
//		System.out.println(student2);
//		
		Address address = (Address) session.get(Address.class, 6);
		System.out.println(address);
		System.out.println(address.getAddedDate());
		
		factory.close();
		session.close();
		System.out.println("Done............");

	}

}
