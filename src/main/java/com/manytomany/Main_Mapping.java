package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_Mapping {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/manytomany/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		employee.setEmployee_Name("Sahil");
		employee2.setEmployee_Name("Shoaib");
		
		
		Project project = new Project();
		Project project2 = new Project();
		project.setProject_Name("Library Management System");
		project2.setProject_Name("CHATBOT");
		
		List<Employee> list = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();
		
		list.add(employee);
		list.add(employee2);
		
		list2.add(project);
		list2.add(project2);
		
		
		employee.setProjects(list2);
		
		project2.setEmployees(list);
		
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(employee);
		session.persist(employee2);
		session.persist(project);
		session.persist(project2);
		transaction.commit();
		session.close();
		factory.close();
		

	}

}
