package fr.skytech.application.test.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.skytech.application.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/test-context.xml" })
@Transactional
public class UserModel {

	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession;

	@Before
	public void openSession() {
		this.currentSession = this.sessionFactory.getCurrentSession();
	}

	@Test
	public void user_create() {
		assertEquals(0, this.currentSession.createQuery("from User").list()
				.size());
		final User user = new User();
		user.setUsername("admin");

		this.currentSession.persist(user);
		this.currentSession.flush();
		assertEquals(1, this.currentSession.createQuery("from User").list()
				.size());
	}

	@Test
	public void user_find_by_username() {
		final User user = new User();
		user.setUsername("admin");
		this.currentSession.persist(user);
		this.currentSession.flush();

		assertEquals(
				1,
				this.currentSession
						.createQuery("from User where username = 'admin'")
						.list().size());
		assertEquals(
				0,
				this.currentSession
						.createQuery("from User where username = 'mrlo'")
						.list().size());
	}
}