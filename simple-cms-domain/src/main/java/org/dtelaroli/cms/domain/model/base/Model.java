package org.dtelaroli.cms.domain.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.caelum.vraptor.actions.api.db.IModel;

import com.google.common.base.Objects;

@MappedSuperclass
public class Model implements IModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Model() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
				.toString();
	}

}
