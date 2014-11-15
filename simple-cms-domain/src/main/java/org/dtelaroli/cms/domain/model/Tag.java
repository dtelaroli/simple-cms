package org.dtelaroli.cms.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.dtelaroli.cms.domain.model.base.TenantModel;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Tag extends TenantModel {

	@NotBlank
	@Column(length = 80)
	private String name;
	
	public Tag() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
