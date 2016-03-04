/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.FoodHandlerBeanLocal;
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
        this.getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    { 
        
        
        int count=0;
        String fromfile="@@@";
        File file = new File("C:\\Users\\Rock n Roll\\Desktop\\meatsToDb.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine())
        {
          String line = in.nextLine();
          String split[]=line.split(";");
         //Vegetables v=new Vegetables();
         // Fruits v=new Fruits();
         // Starches v=new Starches();
           Meats v=new Meats();
         v.setMeatTitle(split[0]);
         v.setMeatGrams(Integer.parseInt(split[1]));
         v.setMeatMeasurements(split[2]);
         v.setMeatCarbs(Integer.parseInt(split[3]));
     
            //foodHandlerBean.addFruits(v);
           //foodHandlerBean.addStarches(v);
           foodHandlerBean.addMeats(v);
           count++;
        } 
        
        
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
