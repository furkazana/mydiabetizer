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
      //  for(int i=0;i<lenth-3;i++)
      //  {
            
          //  if(i==0 || i+1==0 || i+2==0)
         //   {}
          //  else
          //  {
                
           // }
      //  }
        
        
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
         {    Diarydates diaryDateAndUser = null;
              diaryDateAndUser =  diaryDatesBean.resultExistForTheDay((int) session.getAttribute("userIs"));
            if(diaryDateAndUser==null) 
            {
              diaryDateAndUser= diaryDatesBean.addUserAndDate((int) session.getAttribute("userIs"));
            }
            int j=0;
             for(int i=0 ;i<daylyresults.length;i++)
                    {
          
           //  if(diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(), j))//hard coding diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(),1
           //     {    
                    
                   
                   
                        Double convertedSugar;
                        int convertedInsulin;
                        
                        String sugar = request.getParameter(daylyresults[i]);
                        String insulin = request.getParameter(daylyresults[i+1]);//hard coding
                        String note = request.getParameter(daylyresults[i+2]);
                        
                        if(insulin.equals(""))//catch exception if there is no input and set it up to 0
                        { convertedInsulin=0;}
                        else
                        {convertedInsulin=Integer.parseInt(insulin); }//if there is input converted it.
                        if(sugar.equals(""))
                        { convertedSugar=0.0;}
                        else
                        { convertedSugar=Double.parseDouble(sugar); }
                        
                      if(convertedInsulin!=0 || convertedSugar!=0 )
                      {   
                       
                       // Oob o=new Oob();
                          DiaryFactory dFactory=new DiaryFactory();
                          TimeSlots o = dFactory.getTimeSlots(daylyresults[i]);//hard coding
                      
                      //  o.setOobSugar(convertedSugar);
                      //  o.setOobInsulin(convertedInsulin);
                          o.setSugar(convertedSugar);
                          o.setInsulin(convertedInsulin);
                        diaryDatesBean.addSingleLineResult(o,diaryDateAndUser,daylyresults[i]);//hard coding
                      }
                      i=i+2;
                      j++;
                    }
              //  else {
           // }
               }
            
          
   
         }
        
        
        
        
        
    

  
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
