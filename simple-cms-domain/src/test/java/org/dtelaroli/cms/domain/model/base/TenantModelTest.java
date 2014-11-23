package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TenantModelTest {

	private TenantModel model;
	private Tenant tenant;
	
	@Before
	public void setUp() throws Exception {
		model = new TenantModel(){};
		tenant = new Tenant();
	}

	@Test
	public void shouldHaveTenantProperty() {
		model.setTenant(tenant);
		assertThat(model.getTenant(), equalTo(tenant));
	}
	
	@Test
	public void shouldBeEqual() {
		assertThat(model, equalTo(model));
	}
	
	@Test
	public void shouldReturnToString() {
		assertThat(model.toString(), containsString("{"));
	}
	
	@Test
	public void shouldConstructWithTenant() {
		model = new TenantModel(new Tenant()){};
		assertThat(model.getTenant(), notNullValue());
	}

}
