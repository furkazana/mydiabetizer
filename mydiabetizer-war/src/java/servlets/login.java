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
import javax.servlet.RequestDispatcher;
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
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        response.sendRedirect(request.getContextPath() + "/mypage.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
