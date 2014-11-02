package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;

public class ModelTest {

	private Content model;
	
	@Before
	public void setUp() throws Exception {
		model = new Content();
		model.setTitle("Foo");
		model.setSummary("Bar");
	}

	@Test
	public void shouldPersistModel() {
		Ebean.save(model);
		
		assertThat(model.getId(), notNullValue());
		assertThat(model.getId(), greaterThan(0L));
	}
	
	@Test
	public void shouldSetDatesOnPersist() {
		Ebean.save(model);
		
		assertThat(model.getId(), greaterThan(0L));
		assertThat(model.getCreatedAt(), notNullValue());
		assertThat(model.getUpdatedAt(), notNullValue());
		assertThat(model.getCreatedAt(), equalTo(model.getUpdatedAt()));
	}

	@Test
	public void shouldSetUpdatedDeteOnUpdate() {
		Ebean.save(model);
		assertThat(model.getId(), greaterThan(0L));
		assertThat(model.getCreatedAt(), notNullValue());
		assertThat(model.getUpdatedAt(), notNullValue());
		assertThat(model.getCreatedAt(), equalTo(model.getUpdatedAt()));

		model.setBody("Foo bar");
		Ebean.update(model);
		assertThat(model.getCreatedAt(), lessThan(model.getUpdatedAt()));
	}
	
}
