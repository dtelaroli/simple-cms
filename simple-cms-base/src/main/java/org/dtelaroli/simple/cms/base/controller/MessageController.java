package org.dtelaroli.simple.cms.base.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;

@Controller @Path("/message")
public class MessageController {

	@Get("/404")
	public void e404() {
		
	}
	
	@Get("/500")
	public void e500() {
		
	}
}
