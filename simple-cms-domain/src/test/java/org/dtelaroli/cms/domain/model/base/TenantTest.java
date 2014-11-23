package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;

public class TenantTest {

	private Tenant model;

	@Before
	public void setUp() throws Exception {
		model = new Tenant();
		model.setName("name");
		model.setSlug("slug");
	}

	@Test
	public void shouldPersistModel() {
		Ebean.save(model);
		
		assertThat(model.getId(), greaterThan(0L));
	}
	
	@Test
	public void shouldSetData() {
		assertThat(model.getName(), equalTo("name"));
		
		model.setActive(false);
		assertThat(model.isActive(), equalTo(false));
	}
	
	@Test
	public void shouldReturnToString() {
		model.setId(1L);
		assertThat(model.toString(), containsString("Tenant{1, name"));
	}
	
}
