
/*
 * BarangCtrl.java
 *
 * Created on Feb 3, 2020, 5:06:23 PM
 */
package sunwell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sunwell.entity.Barang;
import sunwell.repository.BarangRepository;
import sunwell.repository.dao.BarangDao;
import sunwell.repository.util.JpaUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Aditia Dwi P.
 */
@RestController
public class BarangCtrl 
{
    @Autowired
    private BarangRepository barangRepo;
    
    @GetMapping("/barang")
    public List<Barang> getAll(@RequestParam(value="id", required=false) Integer id)
    {
        //getAllViaDao(id);
        return getAllViaSpringRepo(id);
    }
    
    private List<Barang> getAllViaSpringRepo(Integer id)
    {
        // Tampung hasil query Spring Repo ke Iterable
        Iterable<Barang> result = barangRepo.findAll();
        
        // Tuangkan data dari bentuk Iterable ke List
        List<Barang> listBarang = new LinkedList();
        for (Barang b : result)
            listBarang.add(b);
        
        return listBarang;
    }
    
    private List<Barang> getAllViaDao(Integer id)
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
    @GetMapping("/barang/{id}")
    private Barang findById(@PathVariable("id") int id)
    {
//        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
//        Barang b = dao.findById(id);
//        if (b == null)
//            return null;
//        
//        return b;
        Optional<Barang> result = barangRepo.findById(id);
        Barang b = result.get();
        return b;
    }
    
    @PostMapping("/barang")
    public Barang addBarang(@RequestParam(value="nama") String nm,
                        @RequestParam(value="harga") double hrg)
    {
//        Barang barang = new Barang();
//        barang.setNama(nm);
//        barang.setHarga(hrg);
//        
//        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
//        barang = dao.create(barang);
//        
//        return barang;
        Barang barang = new Barang();
        barang.setNama(nm);
        barang.setHarga(hrg);
        barangRepo.save(barang);
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
    
    @PatchMapping("/barang/{id}")
    public Barang editBarang(
        @RequestParam(value="nama") String nama,
        @RequestParam(value="harga") double harga,
        @PathVariable("id") int id)
    {
        Barang barangInDb = barangRepo.findById(id).get();
        barangInDb.setId(id);
        barangInDb.setNama(nama);
        barangInDb.setHarga(harga);
        
//        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
//        barang = dao.editBarang(barang);
        barangRepo.save(barangInDb);
        return barangInDb;
    }
    
    @DeleteMapping("/barang/{id}")
    public boolean deleteBarang(@PathVariable("id") int id)
    {
//        BarangDao dao = new BarangDao(JpaUtil.getEntityManagerFactory());
//        return dao.deleteBarang(id);
        barangRepo.deleteById(id);
        return true;
    }
}
