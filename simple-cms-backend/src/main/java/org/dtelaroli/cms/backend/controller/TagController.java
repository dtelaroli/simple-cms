package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Tag;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.actions.api.Act;

@Controller
public class TagController {

	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected TagController() {
		this(null);
	}
	
	@Inject
	public TagController(Act act) {
		this.act = act;
	}

	@Post @Consumes("application/json")
	public void save(@NotNull @Valid Tag tag) {
		act.validator().onErrorSendBadRequest();
		act.as(persist()).save(tag).jsonWithoutRoot().serialize();
	}

}
