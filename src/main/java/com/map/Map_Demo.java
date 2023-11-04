package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Map_Demo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/map/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		// creating object question
//		Question question = new Question();
//		question.setQuestionid(101);
//		question.setQuestion("what is java");
//
//		// creating object answer
//		Answer answer = new Answer();
//		answer.setAnswerid(201);
//		answer.setAnswer("java is a programming launguage");
//		answer.setQuestion(question);
//		question.setAnswer(answer);
//
//		// creating object question
//		Question question1 = new Question();
//		question1.setQuestionid(242);
//		question1.setQuestion("what is collection framework");
//
//		// creating object answer
//		Answer answer1 = new Answer();
//		answer1.setAnswerid(344);
//		answer1.setAnswer("API to works with objects in java");
//        answer1.setQuestion(question1);
//		question1.setAnswer(answer1);
//
//		Question question2 = new Question();
//		question2.setQuestionid(143);
//		question2.setQuestion("what is your name");
//
//		// creating object answer
//		Answer answer2 = new Answer();
//		answer2.setAnswerid(243);
//		answer2.setAnswer("My name is Sameer");
//		answer2.setQuestion(question2);
         
		//question2.setAnswer(answer2);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//session.persist(question);
    //	session.persist(question1);
		/////session.persist(question2);
		//session.persist(answer);
	//	session.persist(answer1);
	//	session.persist(answer2);
		transaction.commit();
		Question question = (Question) session.get(Question.class, 101);
		System.out.println(question.getQuestion());
//		System.out.println(question.getAnswer().getAnswer());
		session.close();
		factory.close();
	}

}
