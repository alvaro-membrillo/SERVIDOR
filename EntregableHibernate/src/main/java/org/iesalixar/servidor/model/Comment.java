package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

	@Id
	private String id;

	@Column
	private String title;
	@Column
	private String content;

	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Comment other = (Comment) obj;

		return Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
