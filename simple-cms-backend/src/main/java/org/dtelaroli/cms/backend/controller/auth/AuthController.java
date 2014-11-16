package org.dtelaroli.cms.backend.controller.auth;

import static br.com.caelum.vraptor.actions.api.Acts.session;

import javax.inject.Inject;

import org.apache.shiro.authz.AuthorizationException;
import org.dtelaroli.simple.cms.base.component.RequestInfo;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;

@Controller
public class AuthController implements AuthorizationRestrictionListener {
   
	private final Act act;
	private final RequestInfo info;
    
    protected AuthController() {
    	this(null, null);
	}
    
    @Inject
    public AuthController(Act act, RequestInfo info) {
		this.act = act;
		this.info = info;
	}

    @Override
    public void onAuthorizationRestriction(AuthorizationException e) {
        act.result().include("error", e.getLocalizedMessage());
        act.result().redirectTo(this).index();     
    }
    
    @Get
    public void index() {
    }
    
    @Post
    public void login(String username, String password, boolean remember) {
    	act.as(session()).login(username, password, remember).redirectTo(info.getContextPath());
    }
    
	@Get
    public void logout() {
		act.as(session()).logout().redirectTo(info.getContextPath());
    }
    
}