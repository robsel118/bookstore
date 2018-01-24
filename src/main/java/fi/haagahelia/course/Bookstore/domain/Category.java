package fi.haagahelia.course.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")
	private List<Book>books;
	
	public long getId() {
		return categoryId;
	}
	public void setId(long id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	public Category() {
		super();
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	public Category(long categoryId, String name, List<Book> books) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.books = books;
	}
	public Category(long id, String name) {
		super();
		this.categoryId = id;
		this.name = name;
	}
	
}
