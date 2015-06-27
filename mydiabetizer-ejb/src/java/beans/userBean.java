/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import ent.Diabetics;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rock n Roll
 */
@Stateless
public class userBean implements userBeanLocal 
{  
    @PersistenceContext(unitName = "mydiabetizer-ejbPU")
    private EntityManager em;
    
   

    protected Diabetics diabetic=null;
    
   

    @Override
    public Diabetics getDiabetic() 
    {
        if(diabetic!=null)
            return diabetic;
        else
        return null;
        
    }

    @Override
    public boolean isValidUsr(String email,String password)
    {     
         //   @NamedQuery(name = "Diabetics.findByEmailAndPassword", query = "SELECT d FROM Diabetics d WHERE d.password = :password and d.email = :email "),

              Query q= em.createNamedQuery("Diabetics.findByEmailAndPassword");
              q.setParameter("email", email);
              q.setParameter("password", password);
              
               List <Diabetics> isin=q.getResultList();
         diabetic=isin.get(0);      
        return !isin.isEmpty(); 
        
        
       
        
    }

    public void persist(Object object) {
        em.persist(object);
    }

  
}
