/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.userBeanLocal;
import controllers.EncryptionControl;
import dp.EncrAlgs;
import ent.Diabetics;
import static ent.Diabetics_.surname;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rock n Roll
 */
public class login extends HttpServlet {

    @EJB
    private userBeanLocal userBean;

     private final String userID = "admin";
     private final String password = "password";
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("JSESSIONID")){
                System.out.println("JSESSIONID="+cookie.getValue());
            }
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        }
        //invalidate the session if exists
        HttpSession session = request.getSession(false);
 
        if(session != null)
        {   session.setAttribute("user",null);
            session.invalidate();
            
        }
        //no encoding because we have invalidated the session
       response.sendRedirect(request.getContextPath() + "/register.jsp");
    }
        
    
        
 
        
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Date date;
        date = userBean.getDate(email);
        String hexPassword = null;

        if (date != null) {
            EncryptionControl encr = new EncrAlgs(password);
            encr.check(date);
            hexPassword = encr.getHexPassword();
        }

         boolean bo = userBean.isValidUsr(email, hexPassword);
         Diabetics d = userBean.getDiabetic();
          if(d.getEmail().equalsIgnoreCase(email)  &&  d.getPassword().equalsIgnoreCase(hexPassword))
            {
            HttpSession session = request.getSession();
            session.setAttribute("user", d.getSurname());
            session.setAttribute("userIs",d.getId());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user",d.getFirstname()+" "+ d.getSurname());
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect(request.getContextPath() + "/home.jsp");
            
        }else{
             
            response.sendRedirect(request.getContextPath() + "/register.jsp");
           
            
        }
          
          
       
        String sirname = d.getSurname();
//        try (PrintWriter out = response.getWriter()) {/* 
//             out.println("<!DOCTYPE html>");
//             out.println("<html>");
//             out.println("<head>");
//             out.println("<title>Servlet login</title>");            
//             out.println("</head>");
//             out.println("<body>");
//                 
//             out.println("<h1>Error</h1>");
//             out.println("<h1>user is:"+d.getEmail()+" password is :"+d.getPassword()+"valid user :"+" </h1>");
//             out.println("<h1>"+"first name to go here" +" </h1>");
//             out.println("</body>");
//             out.println("</html>");
//             */
//
//            //request.setAttribute("SIRNAME",sirname);
//        }
       
      } 

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
