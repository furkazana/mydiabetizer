/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.diaryDatesBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rock n Roll
 */
public class diaryHandler extends HttpServlet
{

    @EJB
    private diaryDatesBean diaryDatesBean;
  
    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
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
         {
            if(diaryDatesBean.resultExistForTheDay((int) session.getAttribute("userIs"))) 
              diaryDatesBean.addUserAndDate((int) session.getAttribute("userIs"));
   
         }
        
        
        
        
        
    }

  
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
