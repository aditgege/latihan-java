/*
 * BookRepository.java
 *
 * Created on Feb 5, 2020, 4:16:54 PM
 */
package sunwell.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sunwell.entity.Book;

/**
 *
 * @author Aditia Dwi P.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>
{
}
