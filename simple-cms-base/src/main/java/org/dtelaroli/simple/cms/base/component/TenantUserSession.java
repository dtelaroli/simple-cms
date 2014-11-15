package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.inject.Specializes;

import org.dtelaroli.cms.domain.model.base.Tenant;

@Specializes
public class TenantUserSession extends UserSession {

	private Tenant tenant;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
}
