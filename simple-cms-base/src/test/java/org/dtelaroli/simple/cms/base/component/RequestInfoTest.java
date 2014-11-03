package org.dtelaroli.simple.cms.base.component;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.dtelaroli.simple.cms.base.controller.MessageController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.controller.DefaultBeanClass;
import br.com.caelum.vraptor.controller.DefaultControllerMethod;
import br.com.caelum.vraptor.events.ControllerFound;

public class RequestInfoTest {

	private RequestInfo info;
	@Mock private ControllerFound controllerFound;
	private BeanClass controller;
	private DefaultControllerMethod method;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		controller = new DefaultBeanClass(MessageController.class);
		method = new DefaultControllerMethod(controller, MessageController.class.getMethod("e500"));
		
		when(controllerFound.getController()).thenReturn(controller);
		when(controllerFound.getMethod()).thenReturn(method);
		
		info = new RequestInfo();
	}

	@Test
	public void shouldSetController() {
		info.includes(controllerFound);
		
		assertThat(info.getController().getType(), typeCompatibleWith(MessageController.class));
	}
	
	@Test
	public void shouldSetMethod() {
		info.includes(controllerFound);
		
		assertThat(info.getAction(), equalTo("e500"));
	}

}
