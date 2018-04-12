package main.database;

import java.lang.reflect.Method;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

/**
 * Provides CRUD services using Hibernate.
 * 
 * @author Sanjeev
 *
 */
public class DatabaseService {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

		return sessionFactory;
	}

	public static Integer insertEntity(Object obj) {
		Session session = getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			Logger.error("Error on inserting new entity", e);
		} finally {
			session.close();
		}

		Logger.info("Inserted new entity " + obj.toString());
		return getIdOfInsertedEntity(obj);
	}

	private static Integer getIdOfInsertedEntity(Object obj) {
		Integer id = null;
		try {
			Method getIdMethod = obj.getClass().getMethod("getId");
			id = (Integer) getIdMethod.invoke(obj);
		} catch (Exception e) {
			Logger.error("Error on reflecting method 'getId'", e);
		}
		return id;
	}
}
