/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Diabetics;
import ent.Fruits;
import ent.Vegetables;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rock n Roll
 */
@Stateless
public class FoodHandlerBean implements FoodHandlerBeanLocal
{

    @PersistenceContext(unitName = "mydiabetizer-ejbPU")
    private EntityManager em;

  

    @Override
    public void addVeg(Vegetables v)
    {
        Query q= em.createNamedQuery("Fruits.getHighestFrID");
        int id=(int) q.getSingleResult()+1;
        v.setVegId(id);
        em.persist(v); 
    }
    @Override
    public void addFruits(Fruits v)
    {
        Query q= em.createNamedQuery("Fruits.findByFruitTitle");
        q.setParameter("fruitTitle", "Banana");
        int id=(int) q.getSingleResult()+1;
        v.setFruitId(id);
        em.persist(v); 
    }
    
    
     @Override
    public List<Fruits> getAllFruits()
    {  
        List <Fruits> fr;
        fr = new  ArrayList<Fruits>();
     //   Query qr = em.createNamedQuery("Fruits.findByFruitTitle");
      //   q.setParameter("fruitTitle", "Banana");
       //  List <Fruits> frr=q.getResultList();
         return fr;
    }
    
    
    public void persist(Object object) {
        em.persist(object);
    }

  
   
    

}
