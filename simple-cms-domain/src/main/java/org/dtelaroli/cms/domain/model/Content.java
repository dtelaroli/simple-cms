package org.dtelaroli.cms.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Content extends Model {

	private static final long serialVersionUID = 1885202008039612248L;

	@Column(length = 255)
	private String title;
	
	@NotNull
	@Column(length = 1024)
	private String summary;
	
	@Lob
	private String body;
	
	private boolean published;
	
	@ManyToMany
	@Valid
	private List<Tag> tags;

	@ManyToMany
	@Valid
	private List<Category> categories;
	
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

}
