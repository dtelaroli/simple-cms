package org.dtelaroli.simple.cms.base.component;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import org.dtelaroli.cms.domain.model.base.Tenant;

import br.com.caelum.vraptor.events.ControllerFound;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.config.GlobalProperties;

@SessionScoped
public class SessionController implements Serializable {
	
	private static final long serialVersionUID = 4645785522740930314L;
	
	private Tenant tenant;

	public SessionController() {
	}
	
	@PostConstruct
	public void sessionStarted() {
		tenant = new Tenant();
		tenant.setName("Default");
		Ebean.save(tenant);
	}
	
	public void start(@Observes ControllerFound controllerFound, ServletContext servletContext) {
		config(servletContext);
	}

	private void config(ServletContext servletContext) {
		servletContext.setAttribute("_tenant", tenant);
		GlobalProperties.setServletContext(servletContext);
	}

}
