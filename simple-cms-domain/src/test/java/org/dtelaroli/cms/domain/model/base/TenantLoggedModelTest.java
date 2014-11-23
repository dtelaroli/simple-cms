package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TenantLoggedModelTest {

	private TenantLoggedModel model;
	private Tenant tenant;
	
	@Before
	public void setUp() throws Exception {
		model = new TenantLoggedModel(){};
		tenant = new Tenant();
	}

	@Test
	public void shouldHaveTenantProperty() {
		model.setTenant(tenant);
		assertThat(model.getTenant(), equalTo(tenant));
	}
	
	@Test
	public void shouldSetData() {
		model = new TenantLoggedModel(tenant){};
		assertThat(model.getTenant(), equalTo(tenant));
	}
	
	@Test
	public void shouldReturnToString() {
		model.setId(1L);
		
		assertThat(model.toString(), containsString("{1"));
	}

}
