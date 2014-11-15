package models;

import javax.persistence.Entity;

import org.dtelaroli.cms.domain.model.base.TenantLoggedModel;

@Entity
public class MyTenantLoggedModel extends TenantLoggedModel {

	private String name;

	public MyTenantLoggedModel() {
	}
	
	public MyTenantLoggedModel(long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
