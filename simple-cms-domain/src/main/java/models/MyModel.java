package models;

import javax.persistence.Entity;

import org.dtelaroli.cms.domain.model.base.LoggedModel;

@Entity
public class MyModel extends LoggedModel {

	private static final long serialVersionUID = -5544370617414899837L;

	private String name;

	public MyModel() {
	}
	
	public MyModel(long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}