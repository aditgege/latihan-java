/*
 * BarangDao.java
 *
 * Created on Feb 3, 2020, 5:13:02 PM
 */
package sunwell.repository.dao;

import sunwell.entity.Barang;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Aditia Dwi P.
 */
public class BarangDao 
{
    private EntityManager em;
    
    public BarangDao(EntityManagerFactory emf)
    {
        em = emf.createEntityManager();
    }
    
    /**
     * Mengembalikan daftar objek Barang yg tersimpan di database.
     * 
     * @return 
     */
    public List<Barang> findAll()
    {
        List<Barang> retval;     // return value
        //Query query = em.createQuery("SELECT b FROM Barang b", Barang.class);
        Query query = em.createNamedQuery("Barang.findAll");
        retval = query.getResultList();
        
        return retval;
    }
    
    /**
     * Mengembalikan objek Barang dengan ID {@code id}. Jika tidak ditemukan 
     * maka null dikembalikan.
     * 
     * @param id
     * @return 
     */
    public Barang findById(int id)
    {
        TypedQuery<Barang> tquery = em.createNamedQuery("Barang.findById", Barang.class);
        tquery.setParameter("id", id);
        Barang retval = null;
        try {
            retval = tquery.getSingleResult();
        }
        catch (NoResultException nre) {
            retval = null;
        }
        
        return retval;
    }
    
    public Barang create(Barang b)
    {
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        
        return b;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean deleteBoros(int id)
    {
        Barang brgToBeDeleted = findById(id);
        if (brgToBeDeleted == null)
            return false;
        
        em.getTransaction().begin();
        em.remove(brgToBeDeleted);
        em.getTransaction().commit();
        
        return true;
    }
    
    public boolean deleteEfisien(int id)
    {
        Query query = em.createNamedQuery("Barang.deleteById");
        query.setParameter("id", id);
        
        em.getTransaction().begin();
        int n = query.executeUpdate();
        em.getTransaction().commit();
        
        return n > 0;
    }
    
    public boolean deleteEfisienNativeSQL(int id)
    {
        String sql = "DELETE FROM barang WHERE id = " + id;
        Query nativeQuery = em.createNativeQuery(sql);
        
        em.getTransaction().begin();
        int n = nativeQuery.executeUpdate();
        em.getTransaction().commit();
        
        return n > 0;
    }
    
    public Barang editBarang(Barang b)
    {
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        return b;
    }
    
    public boolean deleteBarang(int id)
    {
        Barang brgToBeDeleted = findById(id);
        if (brgToBeDeleted == null)
            return false;
        
        em.getTransaction().begin();
        em.remove(brgToBeDeleted);
        em.getTransaction().commit();
        
        return true;
    }
}
