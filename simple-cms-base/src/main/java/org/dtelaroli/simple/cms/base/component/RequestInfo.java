package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.servlet.ServletContext;

import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.events.InterceptorsReady;
import br.com.caelum.vraptor.events.VRaptorInitialized;

@Named("info")
@RequestScoped
public class RequestInfo {

	private BeanClass controller;
	private String action;
	private String contextPath;

	public RequestInfo() {
	}
	
	public void initialized(@Observes VRaptorInitialized vRaptorInitialized, ServletContext context) {
		contextPath = context.getContextPath();
	}
	
	public void ready(@Observes InterceptorsReady interceptorsReady) {
		controller = interceptorsReady.getControllerMethod().getController();
		action = interceptorsReady.getControllerMethod().getMethod().getName();
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
