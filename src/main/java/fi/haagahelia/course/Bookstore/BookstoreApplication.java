package fi.haagahelia.course.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.User;
import fi.haagahelia.course.Bookstore.domain.repository.BookRepository;
import fi.haagahelia.course.Bookstore.domain.repository.CategoryRepository;
import fi.haagahelia.course.Bookstore.domain.repository.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	private static final BCryptPasswordEncoder encrypter = new BCryptPasswordEncoder();

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRep, UserRepository uRep) {
		return (args) -> {

			log.info("save a couple of user");
			User a = new User("user", encrypter.encode("user"), "USER");
			User b = new User("admin", encrypter.encode("admin"), "ADMIN");
			uRep.save(a);
			uRep.save(b);

			log.warn("fetch all users");
			for (User user : uRep.findAll()) {
				log.warn(user.toString());
			}

			log.info("save a couple of categories");
			cRep.save(new Category("Survival"));
			cRep.save(new Category("Fantasy"));
			cRep.save(new Category("Sci-Fi"));

			log.info("save a couple of books");
			repository.save(new Book("The martian", "Andy Weir", "978-0-091956-14-1", 2012, cRep.findOne((long) 1)));
			repository
					.save(new Book("The Hobbitn", "J.R.R Tolkien", "978-0-261-10334-4", 2011, cRep.findOne((long) 2)));

		};
	}
}
