/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.userBeanLocal;
import ent.Diabetics;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rock n Roll
 */
public class login extends HttpServlet {
    @EJB
    private userBeanLocal userBean;

    

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       String email= request.getParameter("email");
       String password= request.getParameter("password");
       boolean bo=userBean.isValidUsr(email,password);
       Diabetics d=userBean.getDiabetic();
                    try (PrintWriter out = response.getWriter()) 
                    {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet login</title>");            
                    out.println("</head>");
                    out.println("<body>");
                 
                    out.println("<h1>Error</h1>");
                    out.println("<h1>user is:"+email+" password is :"+password+"valid user :"+bo+" </h1>");
                    out.println("<h1>"+d.getFirsName()+" </h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
               
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
