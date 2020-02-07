/*
 * BookCategory.java
 *
 * Created on Feb 5, 2020, 3:48:17 PM
 */
package sunwell.entity;

import javax.persistence.*;

/**
 *
 * @author Aditia Dwi P.
 */
@Entity
@Table(name="book_category")
public class BookCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_category_id_seq")
    @SequenceGenerator(name = "book_category_id_seq", sequenceName = "book_category_id_seq", allocationSize = 1)
    private Integer id;
    
    @Column
    private String name;
    
    public BookCategory()
    {
    }
    
    public BookCategory(String name)
    {
        this.name = name;
    }
    
   
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id  = id;
    }
    
    public String getNama(){
        return name;
    }
    
    public void setNama(String name)
    {
        this.name = name;
    }
    
}
