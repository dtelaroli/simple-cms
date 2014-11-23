package org.dtelaroli.cms.admin.controller;

import static br.com.caelum.vraptor.actions.api.Acts.list;
import static br.com.caelum.vraptor.actions.api.Acts.pagination;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Category;
import org.dtelaroli.cms.domain.model.Content;
import org.dtelaroli.cms.domain.model.Role;
import org.dtelaroli.cms.domain.model.Tag;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.action.ListAction;
import br.com.caelum.vraptor.actions.api.db.order.Order;
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
	public Page<Content> index(int page) {
		return act.as(pagination()).with(Order.desc("updatedAt")).page(page).paginate(Content.class);
	}
	
	@Get
	public void add() {
		includes();
	}

	private void includes() {
		ListAction list = act.as(list()).with(Order.asc("name"));
		act.include("tagList", list.all(Tag.class))
			.include("categoryList", list.all(Category.class))
			.include("roleList", list.all(Role.class));
	}

	@Get("/{id}")
	public Content edit(Long id) {
		includes();
		return loadById(id);
	}

	@Post("/") @Put("/{content.id}")
	public void save(@NotNull @Valid Content content) {
		act.onErrorRedirectToReferer().save(content).redirectTo(this).edit(content.getId());
	}

	@Delete("/{id}")
	public void remove(@NotNull Long id) {
		act.onErrorRedirectToReferer().deleteBy(Content.class, id).redirectTo(this).index();		
	}
	
	@Post @Consumes("application/json")
	public void publish(Long id, boolean publish) {
		Content content = loadById(id);
		content.setPublished(publish);
		
		act.onErrorSendBadRequest().save(content).jsonWithoutRoot().serialize();
	}

	private Content loadById(Long id) {
		return act.loadBy(Content.class, id);
	}
}
