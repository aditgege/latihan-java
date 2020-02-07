/*
 * Barang.java
 *
 * Created on Feb 3, 2020, 4:19:45 PM
 */
package sunwell.entity;

import javax.persistence.*;

/**
 *
 * @author Aditia Dwi P.
 */
@Entity
@Table (name="barang")
@NamedQueries ({
    // JPQL = Java Persistence Query Language.
    @NamedQuery(name="Barang.findAll", query="SELECT x FROM Barang x ORDER BY x.nama"),
    @NamedQuery(name="Barang.findById", query="SELECT x FROM Barang x WHERE x.id = :id"),
    @NamedQuery(name="Barang.deleteById", query="DELETE FROM Barang b WHERE b.id = :id")
})
public class Barang
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="barang_id_seq")
    @SequenceGenerator(name="barang_id_seq", sequenceName="barang_id_seq", allocationSize=1)
    private Integer id;
    
    @Column(unique = true)
    private String nama;
    
    @Column
    private double harga;

    public void setBarang( int id , String nama , double harga )
    {
        this.id  = id;
        this.nama = nama;
        this.harga = harga;
    }

    public Integer getId()
    {
        return id;
    }

    public String getNama()
    {
        return nama;
    }

    public double getHarga()
    {
        return harga;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public void setHarga(double harga)
    {
        this.harga = harga;
    }

    @Override
    public String toString()
    {
        return "Barang ID=" + id + " Nama=" + nama + " Harga=" + harga;
    }
}
