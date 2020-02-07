/*
 * BookCategoryRepository.java
 *
 * Created on Feb 5, 2020, 4:16:40 PM
 */
package sunwell.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sunwell.entity.BookCategory;

/**
 *
 * @author Aditia Dwi P.
 */
@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer>
{
    @Modifying
    @Transactional
    @Query("update BookCategory u set u.name = ?1 where u.id = ?2")
    int updateNameById(String name, int id);
}
