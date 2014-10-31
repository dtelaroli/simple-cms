package org.dtelaroli.cms.backend.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.dtelaroli.cms.backend.model.User;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.actions.api.db.pagination.Page;
import br.com.caelum.vraptor.actions.api.test.MockAct;

public class UserControllerTest {

	private UserController controller;
	private MockAct act;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		act = new MockAct().returning(new User(1L, "Foo"));
		user = new User(1L, "Foo");
		controller = new UserController(act);
	}

	@Test
	public void shouldReturnPage() {
		Page<User> paginate = controller.paginate();
		
		List<User> list = paginate.getList();
		User user = list.get(0);

		assertThat(paginate, instanceOf(Page.class));
		assertThat(paginate.getPageSize(), equalTo(1));
		assertThat(user.getId(), equalTo(1L));
		assertThat(user.getName(), equalTo("Foo"));
	}

	@Test
	public void shouldReturnListOnIndex() {
		List<User> list = controller.index();
		
		assertThat(list, notNullValue());
		assertThat(list.get(0).getId(), equalTo(1L));
	}
	
	@Test
	public void shouldReturnUserOnView() {
		act.returning(user);
		User user = controller.view(1L);
		
		assertThat(user, notNullValue());
		assertThat(user.getId(), equalTo(1L));
	}
	
	@Test
	public void shouldReturnUserOnEdit() {
		act.returning(user);
		User user = controller.edit(1L);
		
		assertThat(user, notNullValue());
		assertThat(user.getId(), equalTo(1L));
	}
}
