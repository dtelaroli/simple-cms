package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.list;
import static br.com.caelum.vraptor.plus.api.Actions.load;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.persist;

import java.util.List;

import javax.inject.Inject;

import org.dtelaroli.cms.backend.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.plus.api.Action;
import br.com.caelum.vraptor.plus.api.db.pagination.Page;

/**
 * Created by denilson on 14/10/14.
 */
@Controller @Path("/user")
public class UserController {

	private final Action act;

	/**
	 * @deprecated
	 */
	protected UserController() {
		this(null);
	}

	@Inject
	public UserController(Action act) {
		this.act = act;
	}

	public List<User> index() {
		return act.use(list()).all(User.class);
	}
	
	@Get("/{page}/{limit}")
	public Page<User> paginate(int page, int limit) {
		return act.use(pagination()).page(page).limit(limit).paginate(User.class);
	}
	
	@Get("/{id}")
	public User view(Long id) {
		return act.use(load()).by(User.class, id);
	}
	
	public void add() {
	}
	
	@Get("/{id}/edit")
	public User edit(Long id) {
		return act.use(load()).by(User.class, id);
	}
	
	@Post
	public void save(User user) throws Exception {
		act.use(persist()).save(user).andRedirectTo(getClass()).view(user.getId());
	}
	
	public void remove(Long id) {
		act.use(delete()).by(User.class, id).andRedirectTo(getClass()).index();
	}
	
}
