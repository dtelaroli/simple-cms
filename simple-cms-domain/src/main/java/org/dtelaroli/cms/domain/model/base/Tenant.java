package org.dtelaroli.cms.domain.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

@Entity
public class Tenant extends LoggedModel {

	@NotNull
	@Column(length = 80)
	private String name;
	
	@NotNull
	@Column(length = 80)
	private String slug;
	
	@Column(length = 80)
	private String description;
	
	@Column(length = 80)
	private String domain;
	
	@NotNull
	private boolean active;
	
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
		setSlug(name);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
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
