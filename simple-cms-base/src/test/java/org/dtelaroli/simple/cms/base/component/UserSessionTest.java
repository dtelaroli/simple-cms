package org.dtelaroli.simple.cms.base.component;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.dtelaroli.cms.domain.model.User;
import org.junit.Before;
import org.junit.Test;

public class UserSessionTest {

	private UserSession session;

	@Before
	public void setUp() throws Exception {
		session = new UserSession();
	}

	@Test
	public void shouldSetUser() {
		User user = new User();
		session.setUser(user);
		
		assertThat(session.getUser(), equalTo(user));
	}

}
