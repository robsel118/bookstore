package fi.haagahelia.course.Bookstore.domain.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.haagahelia.course.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	
	List<Book> findByAuthor(@Param("author") String author);
}
