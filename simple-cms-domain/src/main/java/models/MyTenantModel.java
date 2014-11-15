package models;

import javax.persistence.Entity;

import org.dtelaroli.cms.domain.model.base.TenantModel;

@Entity
public class MyTenantModel extends TenantModel {
	
	private String name;

	public MyTenantModel() {
	}
	
	public MyTenantModel(long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
