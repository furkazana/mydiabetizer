/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.FoodHandlerBeanLocal;
import ent.Fruits;
import ent.Vegetables;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int count=0;
        String fromfile="@@@";
        File file = new File("C:\\Users\\Rock n Roll\\Desktop\\fruitsToDb.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine())
        {
          String line = in.nextLine();
         String split[]=line.split(";");
         //Vegetables v=new Vegetables();
         Fruits v=new Fruits();
         v.setFruitTitle(split[0]);
         v.setFruitGrams(Integer.parseInt(split[1]));
         v.setFruitMeasurement(split[2]);
         v.setFruitCarbs(Integer.parseInt(split[3]));
       //  v.setVegGrams(Integer.parseInt(split[1]));
        // v.setVegCarbs(Integer.parseInt(split[3]));
         foodHandlerBean.addFruits(v);
          count++;
        } 
        
        
        
        response.getWriter().write(count+" lines add it");
        //JsonObject value = (JsonObject) Json.createObjectBuilder();
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
