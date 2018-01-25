package fi.haagahelia.course.Bookstore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.course.Bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
}
