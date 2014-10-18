package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.listAll;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.save;
import static br.com.caelum.vraptor.plus.api.Actions.view;

import java.util.List;

import javax.inject.Inject;

import org.dtelaroli.cms.backend.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.plus.api.Action;

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
		User user = new User();
		user.setNome("Bar");
		action.use(save()).save(user);
		
		return action.use(listAll()).all(User.class);
	}
	
	public List<User> paginate(int first, int limit) {
		return action.use(pagination())
				.first(first)
				.limit(limit)
				.all(User.class);
	}
	
	public User get(Long id) {
		return action.use(view()).get(User.class, id);
	}
	
	public void remove(Long id) {
		action.use(delete()).by(User.class, id);
	}
}
