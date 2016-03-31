/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.diaryDatesBean;
import ent.ChartEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import statics.Diary;

/**
 *
 * @author Rock n Roll
 */
public class GraphHandler extends HttpServlet
{

    @EJB
    private diaryDatesBean diaryDatesBean;
  
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<List<ChartEntity>> Charlist= diaryDatesBean.createGraphsData(2);
            Diary d=new Diary();
            
            
            response.setContentType("application/json");
        JsonObject jsonObj = null;
        try {
            jsonObj = d.getJsonCustom1(Charlist);
        } catch (ParseException ex) {
            Logger.getLogger(FoodHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        request.setAttribute("json", jsonObj);
        this.getServletContext().getRequestDispatcher("/graphs.jsp").forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
