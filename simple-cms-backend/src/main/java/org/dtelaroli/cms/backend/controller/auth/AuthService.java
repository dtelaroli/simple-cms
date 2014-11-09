package org.dtelaroli.cms.backend.controller.auth;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;

public class AuthService implements Permission {

	protected AuthService() {
	}
	
    @Override
    public User getUserByUsername(String username) {
        return new User("dtelaroli", "$shiro1$SHA-256$500000$+aenId0IyJcZfOSD0iwNNA==$Lprljm3VT1+3yPjU0zKYRqzqAGIidEytsbsGkDiiDqk=");
    }

    @Override
    public Set<String> getRolesByUser(String username) {
        HashSet<String> set = new HashSet<>();
        
        set.add("backend");
        
		return set;
    }

    @Override
    public Set<String> getPermissionsByRole(String role) {
    	HashSet<String> set = new HashSet<>();
        
        set.add("backend");
        set.add("backend:content");
        set.add("backend:content:index");
        
        return set;
    }
}