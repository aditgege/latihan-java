/*
 * MainApp.java
 *
 * Created on Feb 3, 2020, 3:09:08 PM
 */
package sunwell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sunwell.entity.Book;
import sunwell.entity.BookCategory;
import sunwell.repository.BookCategoryRepository;
import sunwell.repository.BookRepository;

/**
 *
 * @author Aditia Dwi P.
 */
@SpringBootApplication
public class MainApp 
{
//    @Autowired
//    static BookCategoryRepository ctgrRepo;
//
//    @Autowired
//    static BookRepository bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);

//        if (ctgrRepo == null)
//            System.out.println("CTGR REPO NULL");
//        if (bookRepo == null)
//            System.out.println("BOOKREPO NULL");
//
//        BookCategory ctgr = ctgrRepo.findById(2).get();
//
//        Book newBook = new Book();
//        newBook.setName("Apa ada apa");
//        newBook.setBookCategory(ctgr);
//        bookRepo.save(newBook);
//        System.out.println("SELESAI");
    }
    
}
