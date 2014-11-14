package org.dtelaroli.cms.domain.model.base;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.Objects;

@MappedSuperclass
public class LoggedModel extends Model {

	private static final long serialVersionUID = 6028017372969465837L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Calendar createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

	public LoggedModel() {
	}

	@PrePersist
	public void prepareInsert() {
		createdAt = updatedAt = Calendar.getInstance();
	}
	
	@PreUpdate
	public void prepareUpdate() {
		updatedAt = Calendar.getInstance();
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
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
				.addValue(getCreatedAtDate())
				.addValue(getUpdatedAtDate())
				.toString();
	}

	public Object getUpdatedAtDate() {
		if(updatedAt == null) {
			return null;
		}
		return updatedAt.getTime();
	}

	public Date getCreatedAtDate() {
		if(createdAt == null) {
			return null;
		}
		return createdAt.getTime();
	}
	
}
