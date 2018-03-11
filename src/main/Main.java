package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.database.DatabaseService;
import main.model.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("test");
		SessionFactory sessionFactory = DatabaseService.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
