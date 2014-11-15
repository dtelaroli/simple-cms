package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.dtelaroli.cms.domain.model.User;

@SessionScoped @Named("userSession")
public class UserSession {

	private User user;
	
	public UserSession() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
