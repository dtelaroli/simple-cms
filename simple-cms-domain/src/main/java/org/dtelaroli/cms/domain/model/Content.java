package org.dtelaroli.cms.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Content extends Model {

	private static final long serialVersionUID = 1885202008039612248L;

	@Column(length = 255)
	@NotNull
	private String title;
	
	@NotNull
	@Column(length = 1024)
	private String summary;
	
	@Lob
	private String body;
	
	@NotNull
	private boolean published;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	private List<Tag> tags = new ArrayList<>();

	
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

}
