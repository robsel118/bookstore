package fi.haagahelia.course.Bookstore;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	BookController bookController;

	

	@Test
	public void contextLoads() {
		assertNotNull(bookController);
	}

}
