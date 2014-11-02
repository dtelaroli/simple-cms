package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.delete;
import static br.com.caelum.vraptor.actions.api.Acts.load;
import static br.com.caelum.vraptor.actions.api.Acts.pagination;
import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static br.com.caelum.vraptor.view.Results.referer;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Content;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;

@Controller @Path("/content")
public class ContentController {

	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected ContentController() {
		this(null);
	}
	
	@Inject
	public ContentController(Act act) {
		this.act = act;
	}

	public Page<Content> index() {
		return index(1);
	}

	@Get("/index/{page}")
	public Page<Content> index(@NotNull Integer page) {
		onErrorRedirect();
		return act.as(pagination()).page(page).paginate(Content.class);
	}
	
	public void add() {
		
	}

	@Get("/{id}")
	public Content edit(@NotNull @Valid Long id) {
		onErrorRedirect();
		return act.as(load()).by(Content.class, id);
	}

	@Put("/{content.id}")
	public void update(@NotNull @Valid Content content) {
		onErrorRedirect();
		act.as(persist()).update(content).redirectTo(this).edit(content.getId());
	}

	@Post
	public void insert(@NotNull @Valid Content content) {
		onErrorRedirect();
		act.as(persist()).insert(content).redirectTo(this).edit(content.getId());		
	}

	@Delete("/{id}")
	public void remove(@NotNull Long id) {
		onErrorRedirect();
		act.as(delete()).by(Content.class, id).redirectTo(this).index();		
	}

	private void onErrorRedirect() {
		act.validator().onErrorUse(referer()).redirect();
	}
}
