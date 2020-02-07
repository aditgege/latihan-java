/*
 * Book.java
 *
 * Created on Feb 5, 2020, 3:50:23 PM
 */
package sunwell.entity;

import javax.persistence.*;

/**
 *
 * @author Aditia Dwi P.
 */
@Entity
public class Book 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    private Integer id;
    
    @Column
    private String name;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;
    
    public Book()
    {
    }
    
    public Book(String name)
    {
        this.name = name;   
    }
    
    public Book(String name, BookCategory bookCategory)
    {
        this.name = name;
        this.bookCategory = bookCategory;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookCategory getBookCategory()
    {
        return bookCategory;
    }
    
    public void setBookCategory(BookCategory bookCategory)
    {
        this.bookCategory = bookCategory;
    }
    
}
