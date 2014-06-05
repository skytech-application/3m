package fr.skytech.application.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fr.skytech.application.exception.TechnicalException;

public class HibernateFactory {

	private static SessionFactory sessionFactory;
	private static Log log = LogFactory.getLog(HibernateFactory.class);

	/**
	 * Builds a SessionFactory, if it hasn't been already.
	 */
	public static SessionFactory buildIfNeeded() throws TechnicalException {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		} catch (final HibernateException e) {
			throw new TechnicalException(
					"Impossible de créer la session Hibernate");
		}
	}

	/**
	 * Constructs a new Singleton SessionFactory
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory()
			throws HibernateException {
		if (sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}

	public static void close(final Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (final HibernateException ignored) {
				log.error("Couldn't close Session", ignored);
			}
		}
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
			} catch (final HibernateException ignored) {
				log.error("Couldn't close SessionFactory", ignored);
			}
		}
	}

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		final Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() throws HibernateException {
		buildIfNeeded();
		return sessionFactory.openSession();
	}

	public static void rollback(final Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (final HibernateException ignored) {
			log.error("Couldn't rollback Transaction", ignored);
		}
	}

}
