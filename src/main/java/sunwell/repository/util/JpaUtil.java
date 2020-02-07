/*
 * JpaUtil.java
 *
 * Created on Feb 3, 2020, 4:39:47 PM
 */
package sunwell.repository.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aditia Dwi P.
 */
public class JpaUtil 
{
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory()
    {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("nexusPU");
        
        return emf;
    }
}
