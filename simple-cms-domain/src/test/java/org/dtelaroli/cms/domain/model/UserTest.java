package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setEmail("user");
		user.setPassword("password");
	}

	@Test
	public void shouldBeTrueIfEqualPass() {
		user.setConfirm("password");
		assertThat(user.isValid(), equalTo(true));
	}

	@Test
	public void shouldBeFalseIfDiffPass() {
		user.setConfirm("pass");
		assertThat(user.isValid(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfNull() {
		user.setPassword(null);
		user.setConfirm(null);
		
		assertThat(user.isValid(), equalTo(true));
	}
}
