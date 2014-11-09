package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.pagination;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.db.order.Order;
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
		return act.as(pagination()).with(Order.asc("name")).page(page).paginate(User.class);
	}
	
	public void add() {
	}
	
	@Get("/{id}")
	public User edit(@NotNull Long id) {
		return act.onErrorRedirectToReferer().loadBy(User.class, id);
	}
	
	@Post
	public void insert(@NotNull @Valid User user) {
		act.onErrorRedirectToReferer().insert(user).redirectTo(this).edit(user.getId());
	}

	@Put("/{user.id}")
	public void update(@NotNull @Valid User user) {
		act.onErrorRedirectToReferer().update(user).redirectTo(this).edit(user.getId());
	}
	
	@Delete("/{id}")
	public void remove(@NotNull Long id) {
		act.onErrorRedirectToReferer().deleteBy(User.class, id).redirectTo(this).index();
	}
	
}
