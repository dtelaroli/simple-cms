package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.delete;
import static br.com.caelum.vraptor.actions.api.Acts.load;
import static br.com.caelum.vraptor.actions.api.Acts.pagination;
import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static br.com.caelum.vraptor.view.Results.referer;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;

/**
 * Created by denilson on 14/10/14.
 */
@Controller @Path("/user")
public class UserController {

	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected UserController() {
		this(null);
	}

	@Inject
	public UserController(Act act) {
		this.act = act;
	}

	public Page<User> index() {
		return index(1);
	}
	
	@Get("/index/{page}")
	public Page<User> index(@NotNull Integer page) {
		onErrorRedirect();
		return act.as(pagination()).page(page).limit(2).paginate(User.class);
	}
	
	public void add() {
	}
	
	@Get("/{id}/edit")
	public User edit(@NotNull Long id) {
		onErrorRedirect();
		return act.as(load()).by(User.class, id);
	}
	
	public void insert(@NotNull @Valid User user) {
		onErrorRedirect();
		act.as(persist()).insert(user).redirectTo(this).edit(user.getId());
	}

	private void onErrorRedirect() {
		act.validator().onErrorUse(referer()).redirect();
	}
	
	@Put("/{user.id}")
	public void update(@NotNull @Valid User user) {
		onErrorRedirect();
		act.as(persist()).update(user).redirectTo(this).edit(user.getId());
	}
	
	@Delete("/{id}")
	public void remove(@NotNull Long id) {
		onErrorRedirect();
		act.as(delete()).by(User.class, id).redirectTo(this).index();
	}
	
}
