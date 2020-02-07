/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * BarangRepository.java
 *
 * Created on Feb 6, 2020, 10:57:30 AM
 */
package sunwell.repository;

import org.springframework.data.repository.CrudRepository;
import sunwell.entity.Barang;

/**
 *
 * @author Aditia Dwi P.
 */
public interface BarangRepository extends CrudRepository<Barang, Integer>
{

}
