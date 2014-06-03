package fr.skytech.application.test;

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
	public void user_create() {
		assertEquals(0, currentSession.createQuery("from User").list().size());
		User user = new User();
		user.setUsername("admin");
		
		currentSession.persist(user);
		currentSession.flush();
		assertEquals(1, currentSession.createQuery("from User").list().size());
	}
	
	@Test
	public void user_add_friends() {
		assertEquals(0, currentSession.createQuery("from User").list().size());
		User user = new User();
		user.setUsername("admin");
		
		User friend1 = new User();
		friend1.setUsername("friend1");
		currentSession.persist(friend1);
		
		User friend2 = new User();
		friend2.setUsername("friend2");
		currentSession.persist(friend2);
		
		user.getFriends().add(friend1);
		user.getFriends().add(friend2);
		
		currentSession.persist(user);
		currentSession.flush();
		
		User adminUser = (User) currentSession.createQuery("from User where username = 'admin'").uniqueResult();
		assertEquals(2, adminUser.getFriends().size());
	}

	@Test
	public void user_find_by_username() {
		User user = new User();
		user.setUsername("admin");
		currentSession.persist(user);
		currentSession.flush();
		
		assertEquals(1,
				currentSession.createQuery("from User where username = 'admin'")
						.list().size());
		assertEquals(0,
				currentSession.createQuery("from User where username = 'mrlo'")
						.list().size());
	}
}