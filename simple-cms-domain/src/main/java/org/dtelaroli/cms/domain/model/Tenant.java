package org.dtelaroli.cms.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Tenant extends Model {

	private static final long serialVersionUID = 4519604904529310036L;

	@NotBlank
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
	
}
