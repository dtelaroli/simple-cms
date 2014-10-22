package org.dtelaroli.cms.backend;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.view.LinkToHandler;

@Specializes
public class VelocityLinkToHandler extends LinkToHandler {

	private ServletContext context;

	/** 
	 * @deprecated CDI eyes only
	 */
	protected VelocityLinkToHandler() {
		this(null, null, null);
	}

	@Inject
	public VelocityLinkToHandler(ServletContext context, Router router, Proxifier proxifier) {
		super(context, router, proxifier);
		this.context = context;
	}
	
	public void init(@Observes VRaptorInitialized init) {
		context.setAttribute("linkTo", this);
	}
	
}
