package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.delete;
import static br.com.caelum.vraptor.actions.api.Acts.load;
import static br.com.caelum.vraptor.actions.api.Acts.pagination;
import static br.com.caelum.vraptor.actions.api.Acts.persist;

import org.dtelaroli.cms.domain.model.Content;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;

@Controller
public class ContentController {

	private final Act act;

	protected ContentController() {
		this(null);
	}
	
	public ContentController(Act act) {
		this.act = act;
	}

	public Page<Content> index() {
		return index(1);
	}

	@Get("/index/{page}")
	public Page<Content> index(int page) {
		return act.as(pagination()).page(page).paginate(Content.class);
	}

	public Content edit(Long id) {
		return act.as(load()).by(Content.class, id);
	}

	public void update(Content content) {
		act.as(persist()).update(content).redirectTo(this).edit(content.getId());
	}

	public void insert(Content content) {
		act.as(persist()).insert(content).redirectTo(this).edit(content.getId());		
	}

	public void remove(Long id) {
		act.as(delete()).by(Content.class, id).redirectTo(this).index();		
	}

}
