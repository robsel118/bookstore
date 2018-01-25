package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.repository.BookRepository;
import fi.haagahelia.course.Bookstore.domain.repository.CategoryRepository;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository cRepo;
    
    @Test
    public void createNewBook() {
    	//check total book
    	int count=(int)repository.count();
    	
    	Category cat=cRepo.findOne((long)3);
    	Book book =new Book("Ready Player One", "Ernest Cline","9782266242332",2011,cat);
    	repository.save(book);
    	
    	//check if total is increased
    	assertThat((int)repository.count()==count+1);

    }    
    @Test
    public void deleteBook() {
    	repository.delete((long)1);
    	
    
    	assertTrue(repository.count()==1);

    }    

    
    
    @Test
    public void findBook() {
    	List<Book>books=(List<Book>)repository.findByAuthor("Andy Weir");
    	for (Book book2 : books) {
			System.err.println(book2);
		}
    	
    	assertEquals(1, books.size());

    }    

}