package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.dtelaroli.cms.domain.model.Role;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.actions.api.test.MockAct;
import br.com.caelum.vraptor.util.test.MockSerializationResult;

public class RoleControllerTest {

	private RoleController controller;
	private MockAct act;
	private MockSerializationResult result;
	private Role role;

	@Before
	public void setUp() throws Exception {
		role = new Role();
		role.setId(1L);
		role.setName("name");

		result = new MockSerializationResult();
		act = spy(new MockAct(result).returning(role));
		
		controller = new RoleController(act);
	}

	@Test
	public void shouldSaveTag() throws Exception {
		controller.save(role);
		
		verify(act).as(persist());
		assertThat(result.serializedResult(), containsString("{\"name\":\"name\",\"accessLevel\":0,\"id\":1}"));
	}
	
}
