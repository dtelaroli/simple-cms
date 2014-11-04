package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.dtelaroli.cms.domain.model.Tag;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.actions.api.test.MockAct;
import br.com.caelum.vraptor.util.test.MockSerializationResult;

public class TagControllerTest {

	private TagController controller;
	private MockAct act;
	private Tag tag;
	private MockSerializationResult result;

	@Before
	public void setUp() throws Exception {
		tag = new Tag();
		tag.setId(1L);
		tag.setName("Foo");

		result = new MockSerializationResult();
		act = spy(new MockAct(result).returning(tag));
		
		controller = new TagController(act);
	}

	@Test
	public void shouldSaveTag() throws Exception {
		controller.save(tag);
		
		verify(act).as(persist());
		assertThat(result.serializedResult(), containsString("\"tag\":{\"id\":1"));
	}

}
