package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "userName", unique = true, nullable = false)
	private String userName;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;

	private Post post;
	

	@OneToMany(mappedBy = "comments", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet();

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts = new HashSet();

	@OneToMany(mappedBy = "valoracion", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valoracion> valoraciones = new HashSet();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userName, String password, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// MÉTODOS HELPERS
	public void addComment(final Comment comment) {
		this.comments.add(comment);
		comment.setUser(this);
	}

	public void removeComment(final Comment comment) {
		this.comments.remove(comment);
		comment.setUser(null);
	}

	// MÉTODOS HELPERS
	public void addPost(final Post post) {
		this.posts.add(post);
		post.setUser(this);
	}

	public void removePost(final Post post) {
		this.posts.remove(post);
		post.setUser(null);
	}

	// MÉTODOS HELPERS
	public void addValoracion(final Valoracion valoracion) {
		this.valoraciones.add(valoracion);
		valoracion.setUser(this);
	}

	public void removeValoracion(final Valoracion valoracion) {
		this.valoraciones.remove(valoracion);
		valoracion.setUser(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

}
