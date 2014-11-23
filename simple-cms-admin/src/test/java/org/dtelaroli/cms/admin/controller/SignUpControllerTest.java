package org.dtelaroli.cms.admin.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.dtelaroli.cms.admin.controller.SignUpController;
import org.dtelaroli.cms.domain.model.User;
import org.dtelaroli.cms.domain.model.base.Tenant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.Act;
import br.com.caelum.vraptor.actions.api.Db;
import br.com.caelum.vraptor.actions.core.test.MockAct;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Validator;

public class SignUpControllerTest {

	private SignUpController controller;
	private Act act;
	private User user;
	private Tenant tenant;
	@Mock private Result result;
	@Mock private Db db;
	@Mock private Validator validator;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		validator = new MockValidator();
		result = new MockResult();
		act = spy(new MockAct(result, db, validator));
		
		controller = new SignUpController(act);
		user = new User();
		tenant = new Tenant();
	}

	@Test
	public void shouldHaveIndex() {
		controller.index();
	}

	@Test
	public void shouldSaveTenant() throws Exception {
		controller.create(user, tenant);
		InOrder order = inOrder(act);
		order.verify(act).save(tenant);
		order.verify(act).save(user);
	}
	
	@Test
	public void shouldRedirectOnError() throws Exception {
		doThrow(Exception.class).when(db).use(any());
		
		controller.create(user, tenant);
		verify(act).onErrorRedirectToReferer();
	}
}
