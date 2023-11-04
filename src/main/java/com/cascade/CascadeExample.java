package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onetomany.Answer1;
import com.onetomany.Question1;

public class CascadeExample {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Question1 question1 = new Question1();
		question1.setQuestion("what is swing framework...");

		Answer1 answer1 = new Answer1();
		answer1.setAnswer("use for development");
		answer1.setQuestion1(question1);

		Answer1 answer2 = new Answer1();
		answer2.setAnswer("Desktop");
		answer2.setQuestion1(question1);

		Answer1 answer3 = new Answer1();
		answer3.setAnswer("learn by programmers");
		answer3.setQuestion1(question1);

		List<Answer1> list = new ArrayList<Answer1>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);

		question1.setAnswer1(list);

		Transaction transaction = session.beginTransaction();
		session.persist(question1);

		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
