package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import javax.validation.Validation;
import javax.validation.Validator;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;

public class ContentTest {

	private Content model;

	@Before
	public void setUp() throws Exception {
		model = new Content();
		model.setTitle("Name");
		model.setBody("body");
		model.setSummary("summary");
		model.setCategory(new Category());
		model.setRoles(Arrays.asList(new Role()));
		model.setTags(Arrays.asList(new Tag()));
		model.setTenant(new Tenant());
	}

	@Test
	public void shouldBeValid() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		assertThat(validator.validate(model), empty());
	}
	
	@Test
	public void shouldSetData() {
		assertThat(model.getTitle(), equalTo("Name"));
		assertThat(model.getBody(), equalTo("body"));
		assertThat(model.getSummary(), equalTo("summary"));
		assertThat(model.getCategory(), notNullValue());
		assertThat(model.getRoles(), not(empty()));
		assertThat(model.getTags(), not(empty()));
		
		model.setAccessLevel(0);
		assertThat(model.getAccessLevel(), equalTo(0));
		model.setPublished(true);
		assertThat(model.isPublished(), equalTo(true));
	}
	
}
