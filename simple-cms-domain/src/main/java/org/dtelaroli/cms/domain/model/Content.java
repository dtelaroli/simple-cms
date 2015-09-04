package org.dtelaroli.cms.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.base.TenantLoggedModel;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Content extends TenantLoggedModel {

	@Column(length = 255)
	@NotBlank
	private String title;
	
	@NotBlank
	@Column(length = 1024)
	private String summary;
	
	private String body;
	
	@NotNull
	private boolean published;
	
	@ManyToOne
	private Category category;
	
	@Min(value = 0)
	private Integer accessLevel;
	
	@ManyToMany
	private List<Tag> tags = new ArrayList<>();
	
	@ManyToMany
	private List<Role> roles = new ArrayList<>();
	
	public Content() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}

}
