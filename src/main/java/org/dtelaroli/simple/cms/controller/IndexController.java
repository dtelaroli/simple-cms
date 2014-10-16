package org.dtelaroli.simple.cms.controller;

import java.util.List;

import javax.inject.Inject;

import org.dtelaroli.simple.cms.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

import com.avaje.ebean.Ebean;

/**
 * Created by denilson on 14/10/14.
 */
@Controller
public class IndexController {

    private final Result result;

    /**
     * @deprecated
     */
    protected IndexController() {
        this(null);
    }

    @Inject
    public IndexController(Result result) {
        this.result = result;
    }

    public void index() {
    	User user = new User();
    	user.setNome("Foo");
    	Ebean.save(user);
    	
    	User user1 = Ebean.find(User.class, 1L);
    	result.include("user", user1);
    	
    	List<User> users = Ebean.find(User.class).findList();
    	result.include("users", users);
    }
}
