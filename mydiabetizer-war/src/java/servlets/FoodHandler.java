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
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import statics.CarbsHandler;
//import com.google.gson.Gson;

/**
 *
 * @author Rock n Roll
 */
public class FoodHandler extends HttpServlet {

    @EJB
    private FoodHandlerBeanLocal foodHandlerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Fruits> fruitsList = foodHandlerBean.getAllFruits();
        request.setAttribute("fruitsList", fruitsList);
        List<Starches> starchesList = foodHandlerBean.getAllStarches();
        request.setAttribute("starchesList", starchesList);
        List<Meats> meatsList = foodHandlerBean.getAllMeats();
        request.setAttribute("meatsList", meatsList);
        List<Vegetables> vegList = foodHandlerBean.getAllVegetables();
        request.setAttribute("vegList", vegList);
        List<Fatsandsweets> FatsandsweetsList = foodHandlerBean.getAllFatsandsweets();
        request.setAttribute("FatsandsweetsList", FatsandsweetsList);
        List<Beverages> BeveragesList = foodHandlerBean.getAllBeverages();
        request.setAttribute("BeveragesList", BeveragesList);
        this.getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JsonReader jr = Json.createReader(request.getInputStream());
        JsonObject jo = jr.readObject();
        String mealData = jo.getJsonString("mealData").getString();
        String ill = jo.getJsonString("ill").getString();
        String activity = jo.getJsonString("activity").getString();
        
        CarbsHandler ch = new CarbsHandler();
        String carbs = ch.Run(mealData,ill,activity);
   // Food f =ch.Run(data);

        request.setAttribute("test", activity);
        this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response); //chceki
//       

        /* 
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
        
        
        
    
       
        
        
        
         //         List <Fruits> fruitsList;
         //         fruitsList= foodHandlerBean.getAllFruits();
        
        
         //  response.getWriter().write(fruitsList.get(3).getFruitTitle()+"e te tva e");
         //JsonObject value = (JsonObject) Json.createObjectBuilder();
         */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
