/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import ent.Bb;
import ent.Diarydates;
import ent.Oob;
import ent.TimeSlots;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
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
    
    private final String queries[]={"Oob.findByOobUserDateId","Bb.findByBbUserDateId","Bplus2.findByOobUserDateId",
                                    "Bl.findByOobUserDateId","Lplus2.findByOobUserDateId",
                                    "Bd.findByOobUserDateId","Dplus2.findByOobUserDateId",
                                    "Bbed.findByOobUserDateId","Random.findByOobUserDateId"};
    
    private final String userIds[]={"oobUserDateId","bbUserDateId","b2UserDateId",
                                    "blUserDateId","l2UserDateId",
                                    "bdUserDateId","d2UserDateId",
                                    "bbedUserDateId","randomUserDateId"};//need to be udated
    public Diarydates addUserAndDate(int id)
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
         return diary;
    }
    
    public Diarydates resultExistForTheDay(int id)
    {
          Diarydates nul;
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
           nul=null;//return true if list is empty
       }
       else
           nul=dd.get(0);//return false if there is a addition to the list
        }
       catch(javax.ejb.EJBException e) 
       {
           nul=null;//return true if catch ejb exception -posible when can find data in the data base
          
       }
         return nul;
    }
    public boolean isTimeLine(int id,int qNumber)
    {    
         List<Bb> ob;
         boolean nul;
         
         try
        {
         // Query q= em.createNamedQuery(queries[qNumber]);
           //     q.setParameter(userIds[qNumber],id); 
           //     ob = q.getResultList();
                Query q= em.createNamedQuery(queries[qNumber]);
                q.setParameter(userIds[qNumber],id); 
                ob = q.getResultList();
            
       int size = ob.size();
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
    public void addSingleLineResult(TimeSlots o,Diarydates d,String type)
    {
        
         DiaryFactory dFactory=new DiaryFactory();
         
         TimeSlots oob=dFactory.getTimeSlots(type);
         DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
         Date date = new Date();
         
         oob.setUserDateId(d.getDiarydateId());
         oob.setInsulin(o.getInsulin());
         oob.setSugar(o.getSugar());
         oob.setTime(dateFormat.format(date));
         
         
       //  oob.setOobUserDateId(d.getDiarydateId());
       //  oob.setOobInsulin(o.getOobInsulin());
       //  oob.setOobSugar(o.getOobSugar());
       //  oob.setOobTime(dateFormat.format(date));
         
         em.persist(oob);
        
    }
    
    public void persist(Object object) {
        em.persist(object);
    }


}
