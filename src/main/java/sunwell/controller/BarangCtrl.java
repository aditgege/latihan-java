
/*
 * BarangCtrl.java
 *
 * Created on Feb 3, 2020, 5:06:23 PM
 */
package sunwell.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sunwell.entity.Barang;
import sunwell.repository.dao.BarangDao;
import sunwell.repository.util.JpaUtil;

/**
 *
 * @author Aditia Dwi P.
 */
@RestController
public class BarangCtrl 
{
    @GetMapping("/barang")
    public List<Barang> getAll(@RequestParam(value="id", required=false) Integer id)
    {
        // minta class DAO (Data Access Objek) utk baca dari database daftar barang.
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        if (id == null) {
            List<Barang> hasil = dao.findAll();
            return hasil;
        }
        else {
            Barang b = findById(id);
            // meski cuma 1 objek tapi simpan juga ke list krn return type dari method ini
            // kudu list
            LinkedList<Barang> list = new LinkedList();
            list.add(b);
            
            return list;
        }
    }
    
    private Barang findById(int id)
    {
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        Barang b = dao.findById(id);
        if (b == null)
            return null;
        
        return b;
    }
    
    @PostMapping("/barang")
    public Barang addBarang(@RequestParam(value="nama") String nm,
                        @RequestParam(value="hrg") double hrg)
    {
        Barang barang = new Barang();
        barang.setNama(nm);
        barang.setHarga(hrg);
        
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        barang = dao.create(barang);
        
        return barang;
    }
    
    @PostMapping("/barang/delete")
    public boolean deleteBarang1(@RequestParam(value="id") int id)
    {
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        
        return dao.deleteBoros(id);
    }
    
    @PostMapping("/barang/deleteE1")
    public boolean deleteBarang2(@RequestParam(value="id") int id)
    {
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        
        return dao.deleteEfisien(id);
    }
    
    @PostMapping("/barang/deleteE2")
    public boolean deleteBarang3(@RequestParam(value="id") int id)
    {
        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
        
        return dao.deleteEfisienNativeSQL(id);
    }
}
