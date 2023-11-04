package com.onetomany;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        // creating object question
        Question1 q = new Question1();
       // q.setQuestionid(101);
        q.setQuestion("what is java");

        // creating object answer
        Answer1 answer = new Answer1();
       // answer.setAnswerid(20);
        answer.setAnswer("java is a programming language....");
        answer.setQuestion1(q);

        // creating object answer
        Answer1 answer1 = new Answer1();
       // answer1.setAnswerid(22);
        answer1.setAnswer("with the help of java we can create software....");
        answer1.setQuestion1(q);

        // creating object answer
        Answer1 answer2 = new Answer1();
       // answer2.setAnswerid(23);
        answer2.setAnswer("Java has different types of frameworks....");
        answer2.setQuestion1(q);

        List<Answer1> list = new ArrayList<Answer1>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);

        q.setAnswer1(list);

        
       
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(q); // Save the question and its associated answers
        session.persist(answer);
        session.persist(answer1);
        session.persist(answer2);
        //fetching data
        Question1 question1 = (Question1)session.get(Question1.class, 1);
        System.out.println(question1.getQuestion());
        
        
        //fetch data using for each loop
        for (Answer1 a : question1.getAnswer1()) {
        	System.out.println(a.getAnswer());
			
		}
        
        //fetching data
        Question1 question2 = (Question1)session.get(Question1.class, 1);
        System.out.println(question2.getQuestion());
        //fetch data using iterator
        List<Answer1> answers = question1.getAnswer1();
     Iterator<Answer1> answerIterator = answers.iterator();
     while (answerIterator.hasNext()) {
         Answer1 a = answerIterator.next();
         System.out.println(a.getAnswer());
     }
       
        transaction.commit();
        factory.close();
    }
}