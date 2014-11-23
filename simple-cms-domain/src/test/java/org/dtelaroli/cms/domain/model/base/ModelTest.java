package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model(){};
	}

	@Test
	public void shouldSetData() {
		model.setId(3L);
		assertThat(model.getId(), equalTo(3L));
	}
	
	@Test
	public void shouldBeEqual() {
		assertThat(model, equalTo(model));
	}
	
	@Test
	public void shouldReturnToString() {
		assertThat(model.toString(), containsString("{"));
	}
	
}
