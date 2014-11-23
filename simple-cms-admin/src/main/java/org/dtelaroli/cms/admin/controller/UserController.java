package org.dtelaroli.cms.admin.controller;

import static br.com.caelum.vraptor.actions.api.Acts.list;
import static br.com.caelum.vraptor.actions.api.Acts.pagination;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Role;
import org.dtelaroli.cms.domain.model.User;

import br.com.caelum.vraptor.Consumes;
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

	@Get
	public Page<User> index() {
		return index(1);
	}
	
	@Get("/index/{page}")
	public Page<User> index(@NotNull Integer page) {
		return act.as(pagination()).with(Order.asc("email")).page(page).paginate(User.class);
	}
	
	@Get
	public void add() {
		includes();
	}
	
	@Get("/{id}")
	public User edit(@NotNull Long id) {
		includes();
		return loadBy(id);
	}

	private User loadBy(Long id) {
		return act.loadBy(User.class, id);
	}
	
	private void includes() {
		List<Role> roles = act.as(list()).with(Order.asc("name")).all(Role.class);
		act.include("roleList", roles);
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

	@Post @Consumes("application/json")
	public void active(Long id, boolean active) {
		User user = loadBy(id);
		user.setActive(active);
		act.save(user).jsonWithoutRoot().serialize();
	}
	
}
