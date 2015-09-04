package models;

import javax.persistence.Entity;

import org.dtelaroli.cms.domain.model.base.TenantLoggedModel;

@Entity
public class MyTenantModel extends TenantLoggedModel {
	
	private static final long serialVersionUID = -3027874225601307107L;

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
