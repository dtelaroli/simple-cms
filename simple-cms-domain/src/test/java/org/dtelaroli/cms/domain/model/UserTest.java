package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import javax.validation.Validation;
import javax.validation.Validator;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class UserTest {

	private User user;
	private Tenant tenant;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		tenant = new Tenant(555L);
		tenant.setName("tenant");
		
		user = new User();
		user.setEmail("user@email.com");
		user.setPassword("password");
		user.setConfirm("password");
		user.setTenant(tenant);
		user.setTenant(tenant);
	}

	@Test
	public void shouldBeValid() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		assertThat(validator.validate(user), empty());
	}
	
	@Test
	public void shouldSetData() {
		user.setActive(false);
		assertThat(user.isActive(), equalTo(false));
		user.setRoles(Arrays.asList(new Role()));
		assertThat(user.getRoles(), not(empty()));
		assertThat(user.getEmail(), equalTo("user@email.com"));
		assertThat(user.getPassword(), equalTo("password"));
		assertThat(user.getConfirm(), equalTo("password"));
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
	
	@Test
	public void shouldBeFalseIfNullOtherNotNull() {
		user.setPassword(null);
		
		assertThat(user.isValid(), equalTo(false));
	}
	
}
