package org.dtelaroli.cms.backend;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.ControllerFound;

@RequestScoped
public class Results {

	public Results() {
	}
	
	public void includes(@Observes ControllerFound controllerFound, Result result) {
		result
			.include("controller", controllerFound.getController())
			.include("action", controllerFound.getMethod().getMethod().getName());
	}
	
}
