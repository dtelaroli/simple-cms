package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.dtelaroli.cms.domain.model.Category;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.actions.core.test.MockAct;
import br.com.caelum.vraptor.util.test.MockSerializationResult;

public class CategoryControllerTest {

	private CategoryController controller;
	private MockAct act;
	private MockSerializationResult result;
	private Category category;

	@Before
	public void setUp() throws Exception {
		category = new Category();
		category.setId(1L);
		category.setName("Category");
		
		result = new MockSerializationResult();
		act = spy(new MockAct(result).returning(category));
		
		controller = new CategoryController(act);
	}

	@Test
	public void shouldSaveCategory() throws Exception {
		controller.save(category);
		
		verify(act).as(persist());
		assertThat(result.serializedResult(), containsString("{\"name\":\"Category\",\"id\":1}"));
	}
	
}
