package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.pagination;
import static br.com.caelum.vraptor.view.Results.referer;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Category;
import org.dtelaroli.cms.domain.model.Content;
import org.dtelaroli.cms.domain.model.Tag;

import br.com.caelum.vraptor.Consumes;
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

	@Get
	public Page<Content> index() {
		return index(1);
	}

	@Get("/index/{page}")
	public Page<Content> index(@NotNull Integer page) {
		onErrorRedirect();
		return act.as(pagination()).page(page).paginate(Content.class);
	}
	
	@Get
	public void add() {
		includes();
	}

	private void includes() {
		List<Tag> tags = act.listAll(Tag.class);
		act.result().include("tagList", tags);
		
		List<Category> categories = act.listAll(Category.class);
		act.result().include("categoryList", categories);
	}

	@Get("/{id}")
	public Content edit(@NotNull @Valid Long id) {
		onErrorRedirect();
		includes();
		return loadById(id);
	}

	@Post("/") @Put("/{content.id}")
	public void save(@NotNull @Valid Content content) {
		onErrorRedirect();
		act.save(content).redirectTo(this).edit(content.getId());
	}

	@Delete("/{id}")
	public void remove(@NotNull Long id) {
		onErrorRedirect();
		act.deleteBy(Content.class, id).redirectTo(this).index();		
	}
	
	@Post @Consumes("application/json")
	public void publish(Long id, boolean publish) {
		Content content = loadById(id);
		content.setPublished(publish);
		
		act.save(content).jsonWithoutRoot().serialize();
	}

	private Content loadById(Long id) {
		return act.loadBy(Content.class, id);
	}

	private void onErrorRedirect() {
		act.validator().onErrorUse(referer()).redirect();
	}
}
