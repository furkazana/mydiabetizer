/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Diabetics;
import ent.Fruits;
import ent.Meats;
import ent.Starches;
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
        Query q= em.createNamedQuery("Vegetables.getHighestVegID");
        int id=(int) q.getSingleResult()+1;
        v.setVegId(id);
        em.persist(v); 
    }
    @Override
    public List<Vegetables> getAllVegetables()
    {
         Query qr = em.createNamedQuery("Vegetables.findAll");
         List <Vegetables> veg= qr.getResultList();
         return veg;
    }
    @Override
    public void addFruits(Fruits v)
    {
        Query q= em.createNamedQuery("Fruits.findByFruitTitle");
        int id=(int) q.getSingleResult()+1;
        v.setFruitId(id);
        em.persist(v); 
    }
    
    
     @Override
    public List<Fruits> getAllFruits()
    {  
        
         Query qr = em.createNamedQuery("Fruits.findAll");
         List <Fruits> frr= qr.getResultList();
         return frr;
    }
    @Override
    public void addStarches(Starches s)
    {
        Query q= em.createNamedQuery("Starches.getHighestStarID");
        int id=(int) q.getSingleResult()+1;
        s.setStarchId(id);
        em.persist(s); 
    }
    @Override
    public List<Starches> getAllStarches()
    {
         Query qr = em.createNamedQuery("Starches.findAll");
         List <Starches> st= qr.getResultList();
         return st;
    }
     @Override
    public void addMeats(Meats m) 
    {
        Query q= em.createNamedQuery("Meats.getHighestMeatID");
        int id=(int) q.getSingleResult()+1;
        m.setMeatId(id);
        em.persist(m); 
    }

    @Override
    public List<Meats> getAllMeats() 
    {
         Query qr = em.createNamedQuery("Meats.findAll");
         List <Meats> meats= qr.getResultList();
         return meats;
    }
    
    
    
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }

    

   

  

  

  
   
    

}
