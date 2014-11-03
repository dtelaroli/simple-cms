package org.dtelaroli.simple.cms.base.component;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.dtelaroli.simple.cms.base.controller.MessageController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.ControllerFound;
import br.com.caelum.vraptor.util.test.MockResult;

public class ExceptionCatchTest {

	private ExceptionCatch exceptionCatch;
	@Spy private Result result = new MockResult();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		exceptionCatch = new ExceptionCatch();
	}

	@Test
	public void shouldSetController() {
		MessageController controller = spy(new MessageController());
		when(result.redirectTo(MessageController.class)).thenReturn(controller);
		
		
		exceptionCatch.configure(new ControllerFound(null), result);
		
		assertThat(result.used(), equalTo(true));
		verify(result).on(Exception.class);
		verify(controller).e500();
	}
	
}
