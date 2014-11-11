package org.dtelaroli.cms.backend.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.dtelaroli.cms.domain.model.Category;
import org.dtelaroli.cms.domain.model.Content;
import org.dtelaroli.cms.domain.model.Role;
import org.dtelaroli.cms.domain.model.Tag;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.actions.api.db.pagination.Page;
import br.com.caelum.vraptor.actions.api.test.MockAct;
import br.com.caelum.vraptor.util.test.MockSerializationResult;

public class ContentControllerTest {

	private ContentController controller;
	private MockAct act;
	private Content content;
	private MockSerializationResult result;
	private Class<?> c = ContentController.class;
	private Tag tag;
	private Category category;
	private Role role;
	
	@Before
	public void setUp() throws Exception {
		content();
		tag();
		category();
		role();
		
		result = spy(new MockSerializationResult());
		act = spy(new MockAct(result).returning(content, tag, category, role));
		
		controller = new ContentController(act);
	}

	private void role() {
		role = new Role();
		role.setId(1L);
		role.setName("Role");
		role.setAccessLevel(1);
	}

	private void category() {
		category = new Category();
		category.setId(1L);
		category.setName("Category");
	}

	private void tag() {
		tag = new Tag();
		tag.setId(1L);
		tag.setName("Tag");
	}

	private void content() {
		content = new Content();
		content.setId(1L);
		content.setTitle("Title");
		content.setBody("Body");
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
	public void shouldIncludeCategoriesOnAdd() {
		controller.add();
		
		List<Category> list = (List<Category>)result.included().get("categoryList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeCategoriesOnEdit() {
		controller.edit(1L);
		
		List<Category> list = (List<Category>)result.included().get("categoryList");
		assertThat(list.get(0), notNullValue());
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
	public void shouldIncludeTagsOnEdit() {
		controller.edit(1L);
		
		List<Tag> list = (List<Tag>)result.included().get("tagList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeRolesOnAdd() {
		controller.add();
		
		List<Role> list = (List<Role>)result.included().get("roleList");
		assertThat(list.get(0), notNullValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeRolesOnEdit() {
		controller.edit(1L);
		
		List<Role> list = (List<Role>)result.included().get("roleList");
		assertThat(list.get(0), notNullValue());
	}

	@Test
	public void shouldLoadAndPublishCategory() throws Exception {
		controller.publish(1L, true);
		
		assertThat(result.serializedResult(), containsString("\"published\":true"));
		verify(act).loadBy(Content.class, 1L);
		verify(act).save(content);
	}
	
	@Test
	public void shouldLoadAndDraftCategory() throws Exception {
		controller.publish(1L, false);
		
		assertThat(result.serializedResult(), containsString("\"published\":false"));
		verify(act).loadBy(Content.class, 1L);
		verify(act).save(content);
	}
}
