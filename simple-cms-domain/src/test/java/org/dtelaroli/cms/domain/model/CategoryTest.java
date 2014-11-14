package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category model;

	@Before
	public void setUp() throws Exception {
		model = new Category();
		model.setName("Name");
		model.setTenant(new Tenant());
	}

	@Test
	public void shouldBeValid() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		assertThat(validator.validate(model), empty());
	}
	
	@Test
	public void shouldSetData() {
		assertThat(model.getName(), equalTo("Name"));
	}
	
}
