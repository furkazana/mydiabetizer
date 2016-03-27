/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.diaryDatesBean;
import ent.Diarydates;
import ent.Oob;
import ent.TimeSlots;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import patterns.DiaryFactory;

/**
 *
 * @author Rock n Roll
 */
public class diaryHandler extends HttpServlet
{

    @EJB
    private diaryDatesBean diaryDatesBean;
    
      String daylyresults[]={"oobSL","oobINS","oobNotes","bbSL","bbINS","bbNotes","b2SL","b2INS","b2Notes",
                             "blSL","blINS","blNotes","l2SL","l2INS","l2Notes","bdSL","bdINS","bdNotes",
                             "d2SL","d2INS","d2Notes","bbedSL","bbedINS","bbedNotes","rSL","rINS","rNotes"};
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int lenth=daylyresults.length;
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
       
         if(session.getAttribute("userIs") == null)
         {
           response.sendRedirect(request.getContextPath() + "/register.jsp");

    } else 
         {     Diarydates diaryDateAndUser = null;
              //checks if there is already results for that user for this current date
              diaryDateAndUser =  diaryDatesBean.resultExistForTheDay((int) session.getAttribute("userIs"));
            if(diaryDateAndUser==null) 
            { //if there is no result found ad result for the user and the current date 
              diaryDateAndUser =  diaryDatesBean.addUserAndDate((int) session.getAttribute("userIs"),"no");
            }
            int j=0;
            //loop though all the inputs fields and if there is an input adding it to the DB
             for(int i=0 ;i<daylyresults.length;i++)
                    {
             //check if there is already result for the time slot for the user for the current date
             //if there is already an input not doing anything
             if(diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(), j))//hard coding diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(),1
                {    
                    
                   
                   
                        Double convertedSugar;
                        int convertedInsulin;
                        
                        String sugar = request.getParameter(daylyresults[i]);
                        String insulin = request.getParameter(daylyresults[i+1]);//hard coding
                        String note = request.getParameter(daylyresults[i+2]);
                        
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
                          TimeSlots o = dFactory.getTimeSlots(daylyresults[i]);
                 
                          o.setSugar(convertedSugar);
                          o.setInsulin(convertedInsulin);
                        diaryDatesBean.addSingleLineResult(o,diaryDateAndUser,daylyresults[i]);
                      }
                      i=i+2;
                      j++;
                    }
               else
             {
                      i=i+2;
                      j++;
             }
                    }
          }
    }
              
               
            
          
   
         
        
        
        
        
        
    

  
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
