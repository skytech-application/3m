package fr.skytech.application.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
@ContextConfiguration({"classpath:/test-context.xml"})
@Transactional
public class UserTest {

	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession;

	@Before
	public void openSession() {
		currentSession = sessionFactory.getCurrentSession();
	}

	@Test
	public void shouldHaveASessionFactory() {
		assertNotNull(sessionFactory);
	}

	@Test
	public void shouldHaveNoObjectsAtStart() {
		List<?> results = currentSession.createQuery("from User").list();
		assertTrue(results.isEmpty());
	}

	@Test
	public void shouldBeAbleToPersistAnObject() {
		assertEquals(0, currentSession.createQuery("from User").list().size());
		User user = new User();
		user.setUsername("admin");
		currentSession.persist(user);
		currentSession.flush();
		assertEquals(1, currentSession.createQuery("from User").list().size());
	}

	@Test
	public void shouldBeABleToQueryForObjects() {
		shouldBeAbleToPersistAnObject();

		assertEquals(1,
				currentSession.createQuery("from User where username = 'admin'")
						.list().size());
		assertEquals(0,
				currentSession.createQuery("from User where username = 'mrlo'")
						.list().size());
	}
}