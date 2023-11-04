package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernateProject.Student;

public class HQLPegination {
	public static void main(String[] args) {
		System.out.println("**********WEL COME**********");
		 Configuration configure = new Configuration().configure("com/hibernate.cfg.xml");
		 SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		Query<Student> query = session.createQuery("from Student");
		// implementing pegination using hibernate

		query.setFirstResult(0);
		query.setMaxResults(8);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(
					"ID : " + student.getId() + " NAME : " + student.getName() + "CITY : " + student.getCity());
		}

		
		session.close();
		factory.close();
	}

}
