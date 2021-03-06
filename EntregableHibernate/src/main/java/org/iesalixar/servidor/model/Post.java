package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

	@Id
	private int id;

	@Column
	private String title;
	@Column
	private String content;
	@Column
	private Date date;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valoracion> valoraciones = new HashSet();

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet();

	@ManyToOne
	private User user;
	
	private Valoracion valoracion;

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int id, String title, String content, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	// MÉTODOS HELPERS
	public void addValoracion(final Valoracion valoracion) {
		this.valoraciones.add(valoracion);
		valoracion.setPost(this);
	}

	public void removeValoracion(final Valoracion valoracion) {
		this.valoraciones.remove(valoracion);
		valoracion.setPost(null);
	}
	
	// MÉTODOS HELPERS
	public void addComment(final Comment comment) {
		this.comments.add(comment);
		comment.setPost(this);
	}

	public void removeComment(final Comment comment) {
		this.comments.remove(comment);
		comment.setPost(null);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;

		return Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

}
