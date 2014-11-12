package org.dtelaroli.cms.domain.model;

import java.lang.reflect.Field;
import java.util.Set;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.actions.core.model.Tenant;

import com.avaje.ebean.Query;
import com.avaje.ebean.config.GlobalProperties;
import com.avaje.ebean.event.BeanPersistController;
import com.avaje.ebean.event.BeanPersistRequest;
import com.avaje.ebean.event.BeanQueryAdapter;
import com.avaje.ebean.event.BeanQueryRequest;

public class TenantBeanQueryAdapter implements BeanQueryAdapter, BeanPersistController {

	@Override
	public boolean isRegisterFor(Class<?> cls) {
		return true;
	}

	@Override
	public int getExecutionOrder() {
		return 0;
	}

	@Override
	public void preQuery(BeanQueryRequest<?> request) {
		Query<?> query = request.getQuery();
		query.where().eq("tenant", getTenant());
	}

	private Tenant getTenant() {
		ServletContext servletContext = GlobalProperties.getServletContext();
		return (Tenant) servletContext.getAttribute("tenant");
	}

	@Override
	public boolean preInsert(BeanPersistRequest<?> request) {
		setTenant(request);
		return true;
	}

	private void setTenant(BeanPersistRequest<?> request) {
		try {
			Object bean = request.getBean();
			if(isNotTenantType(bean)) {
				Field field = bean.getClass().getDeclaredField("tenant");
				field.setAccessible(true);
				Tenant tenant = getTenant();
				field.set(request.getBean(), tenant);
			}
		} catch (Exception e) {
		}
	}

	private boolean isNotTenantType(Object bean) {
		return !(bean instanceof Tenant);
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
