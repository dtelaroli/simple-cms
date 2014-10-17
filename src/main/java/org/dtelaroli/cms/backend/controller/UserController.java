package org.dtelaroli.cms.backend.controller;

import java.util.List;

import javax.inject.Inject;

import org.dtelaroli.cms.backend.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.plus.Action;
import br.com.caelum.vraptor.plus.action.ListAllAction;
import br.com.caelum.vraptor.plus.action.PaginateAction;
import br.com.caelum.vraptor.plus.action.RemoveAction;
import br.com.caelum.vraptor.plus.action.ViewAction;

/**
 * Created by denilson on 14/10/14.
 */
@Controller
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
		return action.use(ListAllAction.class).all(User.class);
	}
	
	public List<User> paginate(int first, int limit) {
		return action.use(PaginateAction.class)
				.first(first)
				.limit(limit)
				.all(User.class);
	}
	
	public User view(Long id) {
		return action.use(ViewAction.class).get(User.class, id);
	}
	
	public void remove(Long id) {
		action.use(RemoveAction.class).by(User.class, id);
	}
}
