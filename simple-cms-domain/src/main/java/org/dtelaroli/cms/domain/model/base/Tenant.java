package org.dtelaroli.cms.domain.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

@Entity
public class Tenant extends LoggedModel {

	private static final long serialVersionUID = 5840468752604699321L;

	@NotNull
	@Column(length = 80)
	private String name;
	
	@NotNull
	private boolean active = true;
	
	public Tenant() {
	}

	public Tenant(long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equal(this, obj);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.omitNullValues()
				.addValue(getId())
				.addValue(name)
				.addValue(active)
				.toString();
	}
	
}
