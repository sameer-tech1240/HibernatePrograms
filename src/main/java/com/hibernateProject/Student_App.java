package com.hibernateProject;

//import java.io.FileInputStream;
//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Student_App {

	public static void main(String[] args) throws Exception {
		System.out.println("project started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student student = new Student();
		// student.setId(102);
		student.setName("Yasir");
		student.setCity("Mumbai");

		System.out.println(student);

		// creating object address class
//		Address address = new Address();
//		address.setStreet("street1");
//		address.setCity("Mumbai");
//		address.setOpen(true);
//		address.setAddedDate(new Date());
//		address.setX(1234.54);
//
//		// reading image FileInputStream fileInputStream = new
//		FileInputStream fileInputStream = new FileInputStream("src/main/java/sameer.jpg");
//		byte[] data = new byte[fileInputStream.available()];
//		fileInputStream.read(data);
//		address.setImage(data);

		Session session = factory.openSession();

		Transaction beginTransaction = session.beginTransaction();

		session.persist(student);

		// session.persist(address);
		beginTransaction.commit();

		session.close();
		// fileInputStream.close();
		System.out.println("Done....");

	}
}
