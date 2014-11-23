package org.dtelaroli.cms.admin.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Role;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.actions.api.Act;

@Controller
public class RoleController {

	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected RoleController() {
		this(null);
	}
	
	@Inject
	public RoleController(Act act) {
		this.act = act;
	}

	@Post @Consumes("application/json")
	public void save(@NotNull @Valid Role role) {
		act.onErrorSendBadRequest().save(role).jsonWithoutRoot().serialize();
	}

}
