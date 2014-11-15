package org.dtelaroli.simple.cms.base.component;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;

public class TenantUserSessionTest {

	private TenantUserSession session;

	@Before
	public void setUp() throws Exception {
		session = new TenantUserSession();
	}

	@Test
	public void shouldSetUser() {
		Tenant tenant = new Tenant();
		session.setTenant(tenant);
		assertThat(session.getTenant(), equalTo(tenant));
	}

}
