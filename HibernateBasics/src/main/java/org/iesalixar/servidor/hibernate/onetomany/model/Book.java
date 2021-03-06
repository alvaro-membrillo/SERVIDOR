package org.iesalixar.servidor.hibernate.onetomany.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="books")
public class Book implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(nullable = false, length = 300)
	private String title;
	
	@Column(nullable = false)
	@Min(value=1,message="No hay libros sin hojas")
	private Integer pages;
	
	
	@Column(nullable = true, length = 300)
	private String author;
	
	@Column(nullable = false, unique = true, length = 20)
	private String isbn;
	
	
	@ManyToOne
	private Publisher publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}



	//No tiene sentido el setId ya que es auto generado
	public Long getId() {
		return id;
	}	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", author=" + author + ", isbn=" + isbn + "]";
	}
	
}
