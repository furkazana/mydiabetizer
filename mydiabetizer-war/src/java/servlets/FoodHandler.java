/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.FoodHandlerBeanLocal;
import ent.Beverages;
import ent.Fatsandsweets;
import ent.Fruits;
import ent.Meats;
import ent.Starches;
import ent.Vegetables;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rock n Roll
 */

public class FoodHandler extends HttpServlet
{

    

    @EJB
    private FoodHandlerBeanLocal foodHandlerBean;
    
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        List<Fruits> fruitsList =  foodHandlerBean.getAllFruits();
        request.setAttribute("fruitsList", fruitsList);
        List<Starches> starchesList =  foodHandlerBean.getAllStarches();
       request.setAttribute("starchesList", starchesList);
       List<Meats> meatsList =  foodHandlerBean.getAllMeats();
        request.setAttribute("meatsList", meatsList);
       List<Vegetables> vegList =  foodHandlerBean.getAllVegetables();
        request.setAttribute("vegList", vegList);
        List<Fatsandsweets> FatsandsweetsList =  foodHandlerBean.getAllFatsandsweets();
        request.setAttribute("FatsandsweetsList", FatsandsweetsList);
         List<Beverages> BeveragesList =  foodHandlerBean.getAllBeverages();
        request.setAttribute("BeveragesList", BeveragesList);
        this.getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    { 
        
        
        int count=0;
        String fromfile="@@@";
        File file = new File("C:\\Users\\Rock n Roll\\Desktop\\fatsToDb.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine())
        {
          String line = in.nextLine();
          String split[]=line.split(";");
         //Vegetables v=new Vegetables();
         // Fruits v=new Fruits();
         // Starches v=new Starches();
          // Meats v=new Meats();
         // Beverages v=new Beverages();
         Fatsandsweets v =new Fatsandsweets();
         v.setFnsTitle(split[0]);
         v.setFnsGrams(Integer.parseInt(split[1]));
         v.setFnsMeasurements(split[2]);
         v.setFnsCarbs(Integer.parseInt(split[3]));
     
            //foodHandlerBean.addFruits(v);
           //foodHandlerBean.addStarches(v);
          // foodHandlerBean.addMeats(v);
          //foodHandlerBean.addBeverages(v);
          foodHandlerBean.addFatsandsweets(v);
           count++;
        } 
        
        /*
        
    <div class="list-group list-sub-group margin-top-100 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="beverages">
        <h4 class="main-text-color">Beverages</h4>
<%
    for(Beverages beverage : BeveragesList) {
%>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> grams
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= beverage.getBevTitle()+ " - " + beverage.getBevGrams()+"g approx. " + beverage.getBevMeasurement() %>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
<%    }
%>
    </div>
</div>
 
     <div class="list-group list-sub-group margin-top-100 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="fatsAndSweets">
        <h4 class="main-text-color">Fats and sweets</h4>
<%
    for(Fatsandsweets fatsandsweets : FatsandsweetsList) {
%>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> grams
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= fatsandsweets.getFnsTitle() + " - " + fatsandsweets.getFnsGrams() +"g approx. " + fatsandsweets.getFnsMeasurements() %>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
<%    }
%>
    </div>
</div>
        */
        
        
        
//         List <Fruits> fruitsList;
//         fruitsList= foodHandlerBean.getAllFruits();
        
        
      //  response.getWriter().write(fruitsList.get(3).getFruitTitle()+"e te tva e");
        //JsonObject value = (JsonObject) Json.createObjectBuilder();
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
