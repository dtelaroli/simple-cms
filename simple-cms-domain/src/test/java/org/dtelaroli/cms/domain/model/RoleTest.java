package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;

public class RoleTest {

	private Role role;

	@Before
	public void setUp() throws Exception {
		role = new Role();
		role.setName("Name");
		role.setTenant(new Tenant());
	}

	@Test
	public void shouldBeValid() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		assertThat(validator.validate(role), empty());
	}
	
	@Test
	public void shouldSetData() {
		role.setAccessLevel(1);
		assertThat(role.getAccessLevel(), equalTo(1));
		assertThat(role.getName(), equalTo("Name"));
	}
	
}
