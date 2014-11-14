package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;

public class TagTest {

	private Tag tag;

	@Before
	public void setUp() throws Exception {
		tag = new Tag();
		tag.setName("Name");
		tag.setTenant(new Tenant());
	}

	@Test
	public void shouldBeValid() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		assertThat(validator.validate(tag), empty());
	}
	
	@Test
	public void shouldSetData() {
		assertThat(tag.getName(), equalTo("Name"));
	}
	
}
