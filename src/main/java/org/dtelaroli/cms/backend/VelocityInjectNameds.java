package org.dtelaroli.cms.backend;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.caelum.vraptor.i18n.Translator;
import br.com.caelum.vraptor.view.LinkToHandler;

@ApplicationScoped
public class VelocityInjectNameds {

	private ServletContext context;
	private final LinkToHandler linkTo;
	private final Translator t;

	/** 
	 * @deprecated CDI eyes only
	 */
	protected VelocityInjectNameds() {
		this(null, null, null);
	}

	@Inject
	public VelocityInjectNameds(ServletContext context, LinkToHandler linkTo, Translator t) {
		this.context = context;
		this.linkTo = linkTo;
		this.t = t;
	}
	
	public void init(@Observes VRaptorInitialized init) {
		context.setAttribute("linkTo", linkTo);
		context.setAttribute("t", t);
	}
	
}
