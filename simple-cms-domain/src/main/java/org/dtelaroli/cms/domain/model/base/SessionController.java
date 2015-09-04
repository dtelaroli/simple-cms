package org.dtelaroli.cms.domain.model.base;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import com.avaje.ebean.Ebean;

@SessionScoped
public class SessionController implements Serializable {
	
	private static final long serialVersionUID = 4645785522740930314L;
	
	private Tenant tenant;

	@PostConstruct
	public void sessionStarted() {
		tenant = new Tenant();
		tenant.setName("Default");
		tenant.setSlug("slug");
		Ebean.save(tenant);
	}
	
	public Tenant getTenant() {
		return tenant;
	}
}
