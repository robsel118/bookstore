package fi.haagahelia.course.Bookstore.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.repository.BookRepository;

@RestController
public class BookControllerREST {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
    public @ResponseBody List<Book> booksListRest() {
        return (List<Book>) repository.findAll();
    }
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.GET)
    public @ResponseBody Book findSingleBook(@PathVariable("id") Long  bookdId) {
        return (Book)repository.findOne(bookdId);
    }
}
