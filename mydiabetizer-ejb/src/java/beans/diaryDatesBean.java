/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import ent.Diarydates;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rock n Roll
 */
@Stateless
@LocalBean
public class diaryDatesBean 
{

    @PersistenceContext(unitName = "mydiabetizer-ejbPU")
    private EntityManager em;
    
    
    public void addUserAndDate(int id)
    {  
         Query q= em.createNamedQuery("Diarydates.findHighestTableNumber");
         int tableId=(int) q.getSingleResult()+1;
         Diarydates diary=new Diarydates();
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
         Date date = new Date();
         
         diary.setDiarydateId(tableId);
         diary.setUserId(id);
         diary.setDate(dateFormat.format(date));
         
         em.persist(diary);
    }
    
    public boolean resultExistForTheDay(int id)
    {
          boolean nul;
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
         Date date = new Date();
          List<Diarydates> dd;
         
        try
        {
           Query q= em.createNamedQuery("Diarydates.findByUserIdAndDate");
           q.setParameter("date", dateFormat.format(date));
           q.setParameter("userId", id);
           dd = q.getResultList();
       int size = dd.size();
       if(size==0)
       {
           nul=true;//return true if list is empty
       }
       else
           nul=false;//return false if there is a addition to the list
        }
       catch(javax.ejb.EJBException e) 
       {
           nul=true;//return true if catch ejb exception -posible when can find data in the data base
          
       }
         return nul;
    }

    
    
    public void persist(Object object) {
        em.persist(object);
    }


}
