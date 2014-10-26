package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.list;
import static br.com.caelum.vraptor.plus.api.Actions.load;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.persist;
import static br.com.caelum.vraptor.view.Results.referer;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.backend.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.plus.api.Action;
import br.com.caelum.vraptor.plus.api.db.pagination.Page;
import br.com.caelum.vraptor.validator.Validator;

/**
 * Created by denilson on 14/10/14.
 */
@Controller @Path("/user")
public class UserController {

	private final Action act;
	private final Validator validator;

	/**
	 * @deprecated
	 */
	protected UserController() {
		this(null, null);
	}

	@Inject
	public UserController(Action act, Validator validator) {
		this.act = act;
		this.validator = validator;
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
	public void insert(@NotNull @Valid User user) throws Exception {
		onErrorRedirect();
		act.use(persist()).insert(user).andRedirectTo(getClass()).view(user.getId());
	}

	private void onErrorRedirect() {
		validator.onErrorUse(referer()).redirect();
	}
	
	@Put("/{id}")
	public void update(@NotNull @Valid User user) throws Exception {
		onErrorRedirect();
		act.use(persist()).update(user).andRedirectTo(getClass()).view(user.getId());
	}
	
	@Delete("/{id}")
	public void remove(Long id) {
		act.use(delete()).by(User.class, id).andRedirectTo(getClass()).paginate(1, 2);
	}
	
}
