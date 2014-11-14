package org.dtelaroli.cms.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.base.TenantLoggedModel;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Role extends TenantLoggedModel {

	private static final long serialVersionUID = -8140627201032571675L;

	@NotBlank
	@Column(length = 80)
	private String name;
	
	@NotNull
	private Integer accessLevel = 0;
	
	public Role() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

}
