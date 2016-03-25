/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package statics;

import beans.diaryDatesBean;
import ent.Diarydates;
import ent.TimeSlots;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import patterns.DiaryFactory;

/**
 *
 * @author Rock n Roll
 */
public class Diary 
{

    diaryDatesBean diaryDatesBean = lookupdiaryDatesBeanBean();
    
    
    
    public void addToDiary(String sugar,String insulin,String note,String ill,int id,String type)         
    {

        
        String time="";
        int qur=0;
        
        if(type.equalsIgnoreCase("Breakfast"))
        {
            time="bbSL";
            qur=1;
        }
        if(type.equalsIgnoreCase("Lunch"))
        {
            time="blSL";
            qur=3;
        }
         if(type.equalsIgnoreCase("Dinner"))
        {
            time="bdSL";
            qur=5;
        }
         if(type.equalsIgnoreCase("Snack"))
        {
            time="rSL";
            qur=8;
        }
        
        Diarydates diaryDateAndUser = null;
              //checks if there is already results for that user for this current date
            diaryDateAndUser =  diaryDatesBean.resultExistForTheDay(id);
            if(diaryDateAndUser==null) 
            { //if there is no result found ad result for the user and the current date 
              diaryDateAndUser= diaryDatesBean.addUserAndDate(id,ill);
            }
          
            //loop though all the inputs fields and if there is an input adding it to the DB
         //    for(int i=0 ;i<daylyresults.length;i++)
                //    {
             //check if there is already result for the time slot for the user for the current date
             //if there is already an input not doing anything
             if(diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(), qur))//hard coding diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(),1
                {    
                    
                   
                   
                        Double convertedSugar;
                        int convertedInsulin;
                        
//                        String sugar = request.getParameter(daylyresults[i]);
//                        String insulin = request.getParameter(daylyresults[i+1]);//hard coding
//                        String note = request.getParameter(daylyresults[i+2]);
                        
                        if(insulin.equals(""))//catch exception if there is no input and set it up to 0
                        { convertedInsulin=0;}
                        else
                        {   //trowing error if the input is double//exception needs to be considered and refer to an error
                            convertedInsulin=Integer.parseInt(insulin); }//if there is input converted it.//this
                        
                        if(sugar.equals(""))
                        { convertedSugar=0.0;}
                        else
                        { convertedSugar=Double.parseDouble(sugar); }
                        
                      if(convertedInsulin!=0 || convertedSugar!=0 )
                      {   
                       
                      
                          DiaryFactory dFactory=new DiaryFactory();
                          TimeSlots o = dFactory.getTimeSlots(time);
                 
                          o.setSugar(convertedSugar);
                          o.setInsulin(convertedInsulin);
                          
                        diaryDatesBean.addSingleLineResult(o,diaryDateAndUser,time);
                      }
                    
                    }
    }
       //  }
   // }

    private diaryDatesBean lookupdiaryDatesBeanBean() {
        try {
            Context c = new InitialContext();
            return (diaryDatesBean) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/diaryDatesBean!beans.diaryDatesBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
