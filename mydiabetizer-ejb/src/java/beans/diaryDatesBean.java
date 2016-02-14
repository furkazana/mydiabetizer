/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Diarydates;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
         diary.setDate(date.toString());
         
         em.persist(diary);
    }

    public void persist(Object object) {
        em.persist(object);
    }


}
