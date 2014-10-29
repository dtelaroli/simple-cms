package org.dtelaroli.cms.backend.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.actions.api.Act;

public class UserControllerTest {

	private UserController controller;
	@Mock private Act action;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
//		controller = new UserController(action);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
