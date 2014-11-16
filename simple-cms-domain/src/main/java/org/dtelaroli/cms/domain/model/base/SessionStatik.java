package org.dtelaroli.cms.domain.model.base;

import static br.com.caelum.vraptor.glue.Glue.get;
import static br.com.caelum.vraptor.glue.Glue.put;

import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.glue.Glueing;

@Intercepts(before = Glueing.class)
public class SessionStatik {
	
	private final SessionController session;

	protected SessionStatik() {
		this(null);
	}
	
	@Inject
    public SessionStatik(SessionController session) {
    	this.session = session;
    }

	@BeforeCall
	public void beforeCall() {
		put(SessionController.class, session);
	}
	
    public static SessionController session() {
        return get(SessionController.class);
    }

}
