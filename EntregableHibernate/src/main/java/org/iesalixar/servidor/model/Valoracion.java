package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@IdClass(ValoracionId.class)
public class Valoracion implements Serializable {

	@Id
	@OneToMany
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "post_id", insertable = false, updatable = false)
	private Post post;

	@Column
	private int puntuacion;

	public Valoracion() {
		// TODO Auto-generated constructor stub
	}

	public Valoracion(User user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}

	public Valoracion(User user, Post post, int puntuacion) {
		super();
		this.user = user;
		this.post = post;
		this.puntuacion = puntuacion;
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

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valoracion other = (Valoracion) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UserPost [user=" + user + ", post=" + post + ", puntuacion=" + puntuacion + "]";
	}

}
