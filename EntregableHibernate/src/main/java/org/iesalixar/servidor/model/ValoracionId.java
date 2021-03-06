package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

public class ValoracionId implements Serializable {

	private Long user;
	private Long post;

	public ValoracionId() {
		// TODO Auto-generated constructor stub
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getPost() {
		return post;
	}

	public void setPost(Long post) {
		this.post = post;
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

		ValoracionId other = (ValoracionId) obj;

		if (user == null) {
			if (other.user != null)
				return false;
		} else if (user != other.user)
			return false;

		if (post == null) {
			if (other.post != null)
				return false;
		} else if (post != other.post)
			return false;

		return true;
	}

}
