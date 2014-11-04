package org.dtelaroli.cms.backend.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.dtelaroli.cms.domain.model.Category;
import org.dtelaroli.cms.domain.model.Content;
import org.dtelaroli.cms.domain.model.Tag;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;
import br.com.caelum.vraptor.actions.api.test.MockAct;
import br.com.caelum.vraptor.util.test.MockResult;

public class ContentControllerTest {

	private ContentController controller;
	private MockAct act;
	private Content content;
	private Result result;
	private Class<?> c = ContentController.class;
	private Tag tag;
	private Category category;
	
	@Before
	public void setUp() throws Exception {
		content = new Content();
		content.setId(1L);
		content.setTitle("Title");
		content.setBody("Body");
		
		tag = new Tag();
		tag.setId(1L);
		tag.setName("Tag");
		
		category = new Category();
		category.setId(1L);
		category.setName("Category");
		
		result = spy(new MockResult());
		act = new MockAct(result)
			.returning(content)
			.returning(tag)
			.returning(category);
		
		controller = new ContentController(act);
	}

	@Test
	public void shouldReturnPage() {
		Page<Content> paginate = controller.index();
		
		List<Content> list = paginate.getList();
		Content user = list.get(0);

		assertThat(paginate, instanceOf(Page.class));
		assertThat(paginate.getPageSize(), equalTo(1));
		assertThat(user.getId(), equalTo(1L));
		assertThat(user.getTitle(), equalTo("Title"));
	}

	@Test
	public void shouldReturnContentOnEdit() {
		Content content = controller.edit(1L);
		
		assertThat(content, notNullValue());
		assertThat(content.getId(), equalTo(1L));
	}
	
	@Test
	public void shouldRedirectOnUpdate() {
		controller.save(content);
		
		verify(result).redirectTo(c);
	}
	
	@Test
	public void shouldRedirectOnRemove() {
		controller.remove(1L);
		
		verify(result).redirectTo(c);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeTagsOnAdd() {
		controller.add();
		
		List<Tag> list = (List<Tag>)result.included().get("tagList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeCategoriesOnAdd() {
		controller.add();
		
		List<Category> list = (List<Category>)result.included().get("categoryList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeTagsOnEdit() {
		controller.edit(1L);
		
		List<Tag> list = (List<Tag>)result.included().get("tagList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeCategoriesOnEdit() {
		controller.edit(1L);
		
		List<Category> list = (List<Category>)result.included().get("categoryList");
		assertThat(list.get(0), notNullValue());
	}
}
