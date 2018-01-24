package fi.haagahelia.course.Bookstore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.course.Bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
