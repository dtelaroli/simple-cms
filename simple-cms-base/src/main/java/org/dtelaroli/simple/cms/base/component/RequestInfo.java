package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.servlet.ServletContext;

import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.events.ControllerFound;
import br.com.caelum.vraptor.events.VRaptorInitialized;

@Named("info")
@ApplicationScoped
public class RequestInfo {

	private BeanClass controller;
	private String action;
	private String contextPath;

	public RequestInfo() {
	}
	
	public void initialized(@Observes VRaptorInitialized vRaptorInitialized, ServletContext context) {
		contextPath = context.getContextPath();
	}
	
	public void controllerFound(@Observes ControllerFound controllerFound) {
		controller = controllerFound.getController();
		action = controllerFound.getMethod().getMethod().getName();
	}
	
	public BeanClass getController() {
		return controller;
	}

	public String getAction() {
		return action;
	}

	public String getContextPath() {
		return contextPath;
	}
	
}
