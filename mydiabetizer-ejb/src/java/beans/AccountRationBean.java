/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Userinfo;
import ent.Userratios;
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
public class AccountRationBean implements AccountRationBeanLocal 
{

    @PersistenceContext(unitName = "mydiabetizer-ejbPU")
    private EntityManager em;

    
    @Override
    public void addUserInfo(double  kg, String bodytype, int tdi, String dob,int userId) 
    {
         Query q= em.createNamedQuery("Userinfo.getHighestID");
         int id=(int) q.getSingleResult()+1;
        
        
        Userinfo ui=new Userinfo();
        ui.setKg(kg);
        ui.setBodyType(bodytype);
        ui.setTotalInsulinD(tdi);
        ui.setUserId(userId);
        ui.setUserInfoId(id);
        em.persist(ui);
       
        
    }
    
    @Override
    public void addUserRatio(int id, int br, int lu, int  di, int  general)
    {
       
        //tuka e momenata da se ischisliat ratiotata ako nema info za teh!!!!!!
        
        
        Query q= em.createNamedQuery("Userratios.getHighestID");
        int ratioId=(int) q.getSingleResult()+1;
        
        Userratios  ur=new Userratios ();
        
        ur.setRatioId(ratioId);
        ur.setUserId(id);
        ur.setBreakfast(br);
        ur.setLunch(lu);
        ur.setDiner(di);
        ur.setGeneral(general);
        
        em.persist(ur);
        
    }
    
    
     @Override
    public void updateUserInfo(Userinfo ui) 
    {    
//        Query q1= em.createNamedQuery("Userinfo.findByUserId"); 
//               q1.setParameter("userId", ui.getUserId());
         Query q= em.createNamedQuery("Userinfo.updateUserInfo");
               q.setParameter("userId", ui.getUserId());
               q.setParameter("kg", ui.getKg());
               q.setParameter("bodyType", ui.getBodyType());
               q.setParameter("totalInsulinD", ui.getTotalInsulinD());
   
         q.executeUpdate();
               
//              //em.persist(ui);
//              List <Userinfo> isin= q1.getResultList();
//              Userinfo fd=isin.get(0);
//              fd.setKg(ui.getKg());
//              fd.setBodyType(ui.getBodyType());
//              fd.setTotalInsulinD(ui.getTotalInsulinD());
//               em.merge(fd);
           
        
        
    }

    
    
    
    public void persist(Object object) {
        em.persist(object);
    }

   
  

   
   
    
}
