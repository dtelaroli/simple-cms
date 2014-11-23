package org.dtelaroli.cms.domain.model.base;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Objects;

@MappedSuperclass
public abstract class TenantLoggedModel extends LoggedModel {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Tenant tenant;

	public TenantLoggedModel() {
	}
	
	public TenantLoggedModel(Tenant tenant) {
		this.tenant = tenant;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), tenant);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.omitNullValues()
				.addValue(getId())
				.addValue(getCreatedAtDate())
				.addValue(getUpdatedAtDate())
				.addValue(tenant)
				.toString();
	}
}
