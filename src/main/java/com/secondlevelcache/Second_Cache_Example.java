package com.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernateProject.Student;
public class Second_Cache_Example {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		session.close();

		Session session2 = factory.openSession();

		Student student2 = session2.get(Student.class, 102);
		System.out.println(student2);
		session2.close();

		Session session3 = factory.openSession();
		Student student3 = session3.get(Student.class, 101);
		System.out.println(student3);
		session2.close();

		factory.close();

	}

}
