package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TenantModelTest {

	private TenantModel model;
	private Tenant tenant;
	
	@Before
	public void setUp() throws Exception {
		model = new TenantModel();
		tenant = new Tenant();
	}

	@Test
	public void shouldHaveTenantProperty() {
		model.setTenant(tenant);
		assertThat(model.getTenant(), equalTo(tenant));
	}

}
