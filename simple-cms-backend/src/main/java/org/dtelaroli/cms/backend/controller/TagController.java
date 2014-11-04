package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static br.com.caelum.vraptor.view.Results.json;

import javax.inject.Inject;

import org.dtelaroli.cms.domain.model.Tag;

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

	@Post
	public void save(Tag tag) {
		Tag saved = act.as(persist()).save(tag).andReturn();
		act.result().use(json()).from(saved).serialize();
	}

}
