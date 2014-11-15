package org.dtelaroli.simple.cms.base.component;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.dtelaroli.cms.domain.model.User;

@SessionScoped @Named("userSession")
public class UserSession implements Serializable {

	private static final long serialVersionUID = 4336395662715333752L;
	
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
