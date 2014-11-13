package org.dtelaroli.cms.domain.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.actions.core.model.Tenant;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.config.GlobalProperties;

public class UserTest {

	private User user;
	@Mock private ServletContext context;
	private Tenant tenant;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setEmail("user");
		user.setPassword("password");
	}

	@Test
	public void shouldBeTrueIfEqualPass() {
		user.setConfirm("password");
		assertThat(user.isValid(), equalTo(true));
	}

	@Test
	public void shouldBeFalseIfDiffPass() {
		user.setConfirm("pass");
		assertThat(user.isValid(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfNull() {
		user.setPassword(null);
		user.setConfirm(null);
		
		assertThat(user.isValid(), equalTo(true));
	}
	
//	@Test
	public void schema() {
		tenant = new Tenant(1l);
		when(context.getAttribute("tenant")).thenReturn(tenant);
		when(context.getRealPath("WEB-INF/ebean")).thenReturn("target");
		
		GlobalProperties.setServletContext(context);
		
		Ebean.save(tenant);
		
		Tag tag = new Tag();
		tag.setName("foo");
		
		Ebean.save(tag);
		assertThat(tag, notNullValue());
		assertThat(tag.getId(), notNullValue());
		
		Tag find = Ebean.find(Tag.class, 1L);
		assertThat(find, notNullValue());
		assertThat(find.getTenant(), notNullValue());
		assertThat(find.getTenant().getId(), equalTo(1L));
	}
}
