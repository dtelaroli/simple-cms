package org.dtelaroli.cms.domain.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Objects;

import br.com.caelum.vraptor.actions.api.db.IModel;

@MappedSuperclass
public class Model implements IModel {

	private static final long serialVersionUID = 6028017372969465837L;

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
