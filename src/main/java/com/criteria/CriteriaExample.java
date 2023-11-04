package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernateProject.Student;

public class CriteriaExample {
	
	public static void main(String[] args) {
		Session session = new Configuration().configure("com/hibernate.cfg.xml").buildSessionFactory().openSession();

		
		//--------------------------fetch all data------------------------------------
	Criteria criteria = session.createCriteria(Student.class);
	List<Student> list2 = criteria.list();
	for (Student stu : list2) {
		System.out.println(stu);
	}
		
		// -------------------------like query------------------------------------
		Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.like("name", "%aa%"));

		List<Student> list = c.list();
		for (Student student : list) {
			System.out.println(student);
		}

		// --------------------fetch data like between-----------------------------
		Criteria c1 = session.createCriteria(Student.class);
		c1.add(Restrictions.between("id", 101, 110));
		List<Student> list1 = c1.list();
		for (Student student1 : list1) {
			System.out.println(student1);
		}
		
		Criteria c3 = session.createCriteria(Student.class);
		c3.add(Restrictions.eq("city", "mumbai"));
		List<Student> list3 = c3.list();
		for (Student student3 : list3) {
			System.out.println(student3);
		}
		//--------------------fetch grater than values in table------------------------
		
		Criteria c4 = session.createCriteria(Student.class);
		c4.add(Restrictions.gt("id", 120));
		List<Student> list4 = c4.list();
		for (Student student4 : list4) {
			System.out.println(student4);
		}

		session.close();
	}

}
