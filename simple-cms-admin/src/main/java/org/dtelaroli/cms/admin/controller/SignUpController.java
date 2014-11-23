package org.dtelaroli.cms.admin.controller;

import static br.com.caelum.vraptor.actions.api.Acts.email;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.User;
import org.dtelaroli.cms.domain.model.base.Tenant;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.actions.api.Act;

@Controller @Path("/sign-up")
public class SignUpController {
	
	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected SignUpController() {
		this(null);
	}
	
	@Inject
	public SignUpController(Act act) {
		this.act = act;
	}

	@Get
	public void index() {
	}

	@Post
	public void create(@NotNull @Valid User user, @NotNull @Valid Tenant tenant) throws Exception {
		act.onErrorRedirectToReferer().save(tenant);
		user.setTenant(tenant);
		
		act.save(user);
		
		act.as(email())
			.param("user", user)
			.param("tenant", tenant)
			.subject("Subscribe confirmation")
			.to("ddts80@gmail.com")
			.render("mail-confirmation.vm")
			.send();
		
		act.result().redirectTo(UserController.class).index();
	}

}
