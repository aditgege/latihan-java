/*
 * BookManageCtrl.java
 *
 * Created on Feb 5, 2020, 4:41:14 PM
 */
package sunwell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sunwell.entity.Book;
import sunwell.entity.BookCategory;
import sunwell.repository.BookCategoryRepository;
import sunwell.repository.BookRepository;

/**
 *
 * @author Aditia Dwi P.
 */
@RestController
public class BookManageCtrl
{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCtgrRepo;
    
    @GetMapping("/books")
    public Iterable<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/bookcategory")
    public Iterable<BookCategory> getCategory()
    {
//        Bag, Set  ==> Collection
//            List --> Daftar (sifatnya ada urutan posisi
        return bookCtgrRepo.findAll();
    }

    @PostMapping("/bookcategory")
    public BookCategory createCategory(@RequestParam(name = "name") String name)
    {
        BookCategory bc = new BookCategory();
        bc.setNama(name);
        bookCtgrRepo.save(bc);

        return bc;
    }

    @PostMapping("/book")
    public Book createBook(
            @RequestParam(name = "name") String judul,
            @RequestParam(name = "category") int idCtgr)
    {
        BookCategory ctgr = bookCtgrRepo.findById(idCtgr).get();

        Book newBook = new Book();
        newBook.setName(judul);
        newBook.setBookCategory(ctgr);
        bookRepository.save(newBook);

        return newBook;
    }

    @PatchMapping("/bookcategory/update/{id}")
    public int updateBookCategory(
            @RequestParam(name = "name") String nama,
            @PathVariable(name = "id") Integer id)
    {
//        BookCategory bc = bookCtgrRepo.findById(id).get();
//        bc.setNama(nama);
//
//        bookCtgrRepo.save(bc);
        int rowAffected  = bookCtgrRepo.updateNameById(nama, id);

        return rowAffected;
    }

    @PostMapping("/bookandcategory")
    public Book createBookAndCategory(@RequestParam(name="bookname") String bookName,
                                      @RequestParam(name="categoryname") String ctgrName)
    {
        BookCategory ctgr = new BookCategory();
        ctgr.setNama(ctgrName);

        Book book = new Book();
        book.setName(bookName);
        book.setBookCategory(ctgr);

        bookRepository.save(book);

        return book;
    }
}
