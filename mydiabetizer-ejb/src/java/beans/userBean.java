/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import ent.Diabetics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Date getDate(String email)
    {
        Diabetics d;
        Query q= em.createNamedQuery("Diabetics.findByEmail");
              q.setParameter("email", email);
         
             List <Diabetics> isin=q.getResultList();
             d=isin.get(0); 
             
                 return d.getRegisterDate();
       
    }
    
   

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
    
   

    @Override
    public void storeUser(String firstName,String lastName,String email,String password) {
       
         Query q= em.createNamedQuery("Diabetics.getHighestUserID");
         int id=(int) q.getSingleResult()+1;
        Diabetics d=new Diabetics();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        d.setDiabeticId(id);
        d.setRegisterDate(date);
        d.setEmail(email);
        d.setFirsName(firstName);
        d.setSurname(lastName);
        d.setPassword(password);
                                
       em.persist(d); 
    }

   
}
