package org.dtelaroli.cms.domain.model.base;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.servlet.ServletContext;

import models.MyModel;
import models.MyTenantLoggedModel;
import models.MyTenantModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.glue.Glue;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;

public class TenantBeanControllerTest {

	private TenantBeanController controller;
	private Tenant tenant;
	@Mock private ServletContext context;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		tenant = new Tenant();
		tenant.setName("tenant");
		tenant.setSlug("slug");
		Ebean.save(tenant);
		
		SessionController sessionController = new SessionController();
		sessionController.sessionStarted();
		Glue.put(SessionController.class, sessionController);
		controller = new TenantBeanController();
		
		MyModel myModel = new MyModel();
		myModel.setName("myModel");
		Ebean.save(myModel);
		
		MyTenantModel myTenantModel = new MyTenantModel();
		myTenantModel.setName("myTenantModel");
		Ebean.save(myTenantModel);
		
		Tenant tenant2 = new Tenant();
		tenant2.setName("tenant2");
		tenant2.setSlug("slug2");
		Ebean.save(tenant2);
		MyTenantModel myTenantModel2 = new MyTenantModel();
		myTenantModel2.setName("myTenantModel2");
		myTenantModel2.setTenant(tenant2);
		Ebean.save(myTenantModel2);

	}
	
	@After
	public void tearDown() {
		Ebean.createSqlUpdate("truncate table my_model").execute();
		Ebean.createSqlUpdate("truncate table my_tenant_model").execute();
		Ebean.createSqlUpdate("truncate table my_tenant_logged_model").execute();
	}
	
	@Test
	public void shouldReturnTrueIfModelExtendsTenantModel() {
		assertThat(controller.isRegisterFor(MyTenantModel.class), equalTo(true));
	}
	
	@Test
	public void shouldReturnTrueIfModelExtendsTenantLoggedModel() {
		assertThat(controller.isRegisterFor(MyTenantLoggedModel.class), equalTo(true));
	}

	@Test
	public void shouldReturnFalseIfModelNoExtendsTenantModel() {
		assertThat(controller.isRegisterFor(MyModel.class), equalTo(false));
	}

	@Test
	public void shouldBeOrder0() {
		assertThat(controller.getExecutionOrder(), equalTo(0));
	}
	
	@Test
	public void shouldNotSetTenantPreQuery() {
		Query<MyModel> find = Ebean.find(MyModel.class);
		assertThat(find.findList().size(), equalTo(1));
	}
	
	@Test
	public void shouldSetTenantPreQuery() {
		Query<MyTenantModel> find = Ebean.find(MyTenantModel.class);
		assertThat(find.findList().size(), equalTo(1));
	}
	
	@Test
	public void shouldInsertWithTenant() {
		MyTenantLoggedModel myTenantLoggedModel = new MyTenantLoggedModel();
		myTenantLoggedModel.setName("MyName");
		Ebean.save(myTenantLoggedModel);
	}

}
