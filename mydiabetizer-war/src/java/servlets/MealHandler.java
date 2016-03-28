/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.FoodHandlerBeanLocal;
import ent.Meals;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import statics.CarbsHandler;

/**
 *
 * @author Rock n Roll
 */
public class MealHandler extends HttpServlet 
{

    @EJB
    private FoodHandlerBeanLocal foodHandlerBean;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        JsonReader jr = Json.createReader(request.getInputStream());
        JsonObject jo = jr.readObject();
        JsonObject newMeal = jo.getJsonObject("newMeal");
        String mealName = newMeal.getString("name");
        String ingredients = newMeal.getString("ingredients");
        
        
         CarbsHandler ch = new CarbsHandler();
         String trimptData = ch.tripString(ingredients);
        
        Meals m=new Meals();
        m.setUserId(2);//remove harcodeing get the user id from the session!!!!!!!!
        m.setMealName(mealName);
        m.setMealIngrediens(trimptData);
        foodHandlerBean.addMeal(m);
        
        response.setContentType("application/json");
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject insulinValue = factory.createObjectBuilder()
                .add("success", true).build();
        try (PrintWriter out = response.getWriter()) {
             out.println(insulinValue);
        }
        
        request.setAttribute("test", mealName);
        this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
