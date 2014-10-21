package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.list;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.persist;
import static br.com.caelum.vraptor.plus.api.Actions.view;

import java.util.List;

import javax.inject.Inject;

import org.dtelaroli.cms.backend.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.plus.api.Action;

/**
 * Created by denilson on 14/10/14.
 */
@Controller @Path("/user")
public class UserController {

	private final Action action;

	/**
	 * @deprecated
	 */
	protected UserController() {
		this(null);
	}

	@Inject
	public UserController(Action action) {
		this.action = action;
	}

	public List<User> index() {
		return action.use(list()).all(User.class);
	}
	
	@Get("/{page}/{limit}")
	public List<User> paginate(int page, int limit) {
		return action.use(pagination())
				.page(page)
				.limit(limit)
				.all(User.class);
	}
	
	public User get(Long id) {
		return action.use(view()).load(User.class, id);
	}
	
	public void remove(Long id) {
		action.use(delete()).by(User.class, id);
	}
	
	public void add() {
		User user = new User();
		user.setNome("Bar");
		action.use(persist()).save(user);
	}
}
