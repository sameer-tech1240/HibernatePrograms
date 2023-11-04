package com.unknown;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Booking_App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/unknown/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		User user = new User();
		user.setUsername("Arman");
		user.setEmail("armankhan@123gmail.com");
		user.setPassword("arman@1234567890");
		
		Room room = new Room();
		
		room.setRoomNumber("101");
        room.setCapacity(4);
        room.setPricePerNight(1500.0);
		Booking booking = new Booking();
		booking.setUser(user);
		booking.setRoom(room);
		booking.setCheckInDate(new Date());
		booking.setCheckOutDate(new Date());
		booking.setNumberOfGuests(4);
		booking.setConfirmed(true);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.persist(user);
		session.persist(room);
		session.persist(booking);

		transaction.commit();
		sessionFactory.close();
		System.out.println("Done....");
	}

}
