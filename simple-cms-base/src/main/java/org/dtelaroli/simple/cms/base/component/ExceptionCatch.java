package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.ControllerFound;

@ApplicationScoped
public class ExceptionCatch {

	public ExceptionCatch() {
	}
	
	public void configure(@Observes ControllerFound controllerFound, Result result) {
//		result.on(Exception.class).redirectTo(MessageController.class).e500();
	}

}
