package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.inject.Specializes;

import org.dtelaroli.cms.domain.model.base.Tenant;

@Specializes
public class TenantUserSession extends UserSession {

	private static final long serialVersionUID = -7368808727350559508L;
	
	private Tenant tenant;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
}
