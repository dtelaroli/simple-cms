package org.dtelaroli.cms.domain.model.base;

import java.util.Set;

import com.avaje.ebean.Query;
import com.avaje.ebean.event.BeanPersistController;
import com.avaje.ebean.event.BeanPersistRequest;
import com.avaje.ebean.event.BeanQueryAdapter;
import com.avaje.ebean.event.BeanQueryRequest;

public class TenantBeanController implements BeanQueryAdapter, BeanPersistController {

	private static final String TENANT = "tenant";

	@Override
	public boolean isRegisterFor(Class<?> cls) {
		return TenantModel.class.isAssignableFrom(cls) || TenantLoggedModel.class.isAssignableFrom(cls);
	}

	@Override
	public int getExecutionOrder() {
		return 0;
	}

	@Override
	public void preQuery(BeanQueryRequest<?> request) {
		Query<?> query = request.getQuery();
		query.where().eq(TENANT, getTenant());
	}

	private Tenant getTenant() {
		SessionController controller = SessionStatik.session();
		
		if(controller == null) {
			return null;
		}
		
		if(controller.getTenant() == null) {
			throw new IllegalStateException("Tenant is null. Session is configured correctly?");
		}
		
		return controller.getTenant();
	}

	@Override
	public boolean preInsert(BeanPersistRequest<?> request) {
		setTenant(request);
		return true;
	}

	private void setTenant(BeanPersistRequest<?> request) {
		if(request.getBean() instanceof TenantLoggedModel) {
			TenantLoggedModel bean = (TenantLoggedModel) request.getBean();
			bean.setTenantIfNull(getTenant());
		}
	}

	@Override
	public boolean preUpdate(BeanPersistRequest<?> request) {
		setTenant(request);
		return true;
	}

	@Override
	public boolean preDelete(BeanPersistRequest<?> request) {
		return true;
	}

	@Override
	public void postInsert(BeanPersistRequest<?> request) {
	}

	@Override
	public void postUpdate(BeanPersistRequest<?> request) {
	}

	@Override
	public void postDelete(BeanPersistRequest<?> request) {
	}

	@Override
	public void postLoad(Object bean, Set<String> includedProperties) {
	}

}
