package com.hibernateProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Address {
	public static void main(String[] args) throws IOException {
		System.out.println("project started...");

		Configuration cfg = new Configuration();
	
	   
		cfg.configure("com/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
        
		
		// reading image
		FileInputStream fileInputStream = new FileInputStream("src/main/java/sameer.jpg");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);

		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Mumbai");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1234.54);
		address.setImage(data);

		// reading 2nd image
		FileInputStream file = new FileInputStream("src/main/java/aadil.png");
		byte[] data1 = new byte[file.available()];
		file.read(data1);

		Address address1 = new Address();
		address1.setStreet("street2");
		address1.setCity("Mumbai");
		address1.setOpen(true);
		address1.setAddedDate(new Date());
		address1.setX(12345.54);
		address1.setImage(data1);

		// reading 3rd file

		FileInputStream file1 = new FileInputStream("src/main/java/dilshad.jpg");
		byte[] data2 = new byte[file1.available()];
		file1.read(data2);

		Address address2 = new Address();
		address2.setStreet("street3");
		address2.setCity("Mumbai");
		address2.setOpen(true);
		address2.setAddedDate(new Date());
		address2.setX(145.54);
		address2.setImage(data2);

		Session session = factory.openSession();

		Transaction beginTransaction = session.beginTransaction();

		// session.persist(student);

		session.persist(address);
		session.persist(address1);
		session.persist(address2);
		beginTransaction.commit();

		session.close();
		fileInputStream.close();
		file.close();
		file1.close();
		System.out.println("Done....");

	}

}
