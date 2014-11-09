package org.dtelaroli.cms.backend.controller.auth;

import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import br.com.caelum.vraptor.security.strategy.ShiroInitConfigStrategy;

public class InitConfigStrategy implements ShiroInitConfigStrategy {

	@Override
    public void init(DefaultWebSecurityManager securityManager, AuthorizingRealm realm) {
        DefaultSessionManager sessionManager = (DefaultSessionManager)securityManager.getSessionManager();
		sessionManager.setGlobalSessionTimeout(3600000);
		realm.setCredentialsMatcher(new PasswordMatcher());
    }
}

