/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Fruits;
import ent.Vegetables;
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
        Query q= em.createNamedQuery("Fruits.getHighestFrID");
        int id=(int) q.getSingleResult()+1;
        v.setFruitId(id);
        em.persist(v); 
    }
    
    
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }
    

}
