package org.dtelaroli.cms.backend.controller.auth;

import javax.inject.Inject;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.config.Configuration;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;

@Controller
public class AuthController implements AuthorizationRestrictionListener {
   
	private final Result result;
	private final Subject currentUser;
	private final Configuration cfg;
    
    protected AuthController() {
    	this(null, null, null);
	}
    
    @Inject
    public AuthController(Result result, Subject currentUser, Configuration cfg) {
		this.result = result;
		this.currentUser = currentUser;
		this.cfg = cfg;
	}

    @Override
    public void onAuthorizationRestriction(AuthorizationException e) {
        result.include("error", e.getLocalizedMessage());
        result.redirectTo(this).index();     
    }
    
    @Get
    public void index() {
    }
    
    @Post
    public void login(String username, String password, boolean remember) {
		currentUser.login(new UsernamePasswordToken(username, password, remember));
    	result.redirectTo(cfg.getApplicationPath());
    }
    
    @Get
    public void logout() {
        currentUser.logout();
    }
    
}