package com.hibernateProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class Set_And_Get_App {

	static void main1() throws  IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter 1 for login 2 for register ");
		int loginandRegister = Integer.parseInt(br.readLine());

		if (loginandRegister == 1) {
			System.out.println("login");
			login();

		} else {
			System.out.println("Regester");
			register();
		}

	}

	static void register() throws IOException {
		SetAndGet se = new SetAndGet();

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate_project/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("enter the mail");
		se.setMail(br1.readLine());
		String x = se.getMail();
		System.out.println("enter the UserId");
		se.setUserNameId(Integer.parseInt(br1.readLine()));
		int y = se.getUserNameId();
		System.out.println("Enter password");
		se.setPassword(br1.readLine());
		String z = se.getPassword();

		SetAndGet se2 = (SetAndGet) session.get(SetAndGet.class, y);

		if (se2 == null) {
			System.out.println("Regestration Completed ");
			session.persist(se);
			tx.commit();
			session.close();
			factory.close();

		} else {
			System.out.println("UserName Already Exists");
			register();

		}

	}

	static void login() throws IOException {
		SetAndGet se = new SetAndGet();
		SessionFactory s = new Configuration().configure("com/hibernate_project/hibernate.cfg.xml").buildSessionFactory();
		Session session = s.openSession();

		@SuppressWarnings("unused")
		Transaction transaction = session.beginTransaction();

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the mail");
		se.setMail(br1.readLine());
		String z = se.getMail();

		System.out.println("enter the userId");
		se.setUserNameId(Integer.parseInt(br1.readLine()));
		int y = se.getUserNameId();

		System.out.println("Enter usernamePassword");

		se.setPassword(br1.readLine());
		String x = se.getPassword();
		SetAndGet se2 = (SetAndGet) session.get(SetAndGet.class, y);

		if (se2.getUserNameId() == y) {

			System.out.println("usernameId Right");
			if (se2.getPassword().equals(x)) {
				System.out.println("password Match");
				if (se2.getMail().equals(z)) {
					System.out.println("Email Match");

					System.out.println("Login Succesfully");
				} else {
					System.out.println("email wrong");
				}
			} else {
				System.out.println("Password Wrong");
			}

		} else {
			System.out.println("Wrong Info Givern By User");

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Set_And_Get_App.main1();

	}
}
