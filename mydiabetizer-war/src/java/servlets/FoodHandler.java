/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.FoodHandlerBeanLocal;
import ent.Beverages;
import ent.ChartEntity;
import ent.Fatsandsweets;
import ent.Fruits;
import ent.Meats;
import ent.Starches;
import ent.Vegetables;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import statics.CarbsHandler;
import statics.Diary;
import statics.Insulin;

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
        Map<String, Map<String, String>> meals = foodHandlerBean.getAllMeals(2);//hard codeing needs to be removed with the user sesion
        request.setAttribute("MealsList", meals);
        this.getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            
            int userId=0;
             HttpSession session = request.getSession(false);
        
        if(session != null)
        {   userId=(int) session.getAttribute("userIs");
            
            
        }
        
            JsonReader jr = Json.createReader(request.getInputStream());
            JsonObject jo = jr.readObject();
            String mealData = jo.getJsonString("mealData").getString();
            String ill = jo.getJsonString("ill").getString();
            String activity = jo.getJsonString("activity").getString();
            String mealType = jo.getJsonString("mealType").getString();
            String bloodSugar = jo.getJsonString("bloodSugar").getString();
             
        
    
            CarbsHandler ch = new CarbsHandler();
            String carbs = ch.Run(mealData, ill, activity);
            
            double bs=0.0;
            
            try {
                
                bs=Double.parseDouble(bloodSugar);
            }
            catch(NumberFormatException e)
            {
                
            }
            
            
            
            Insulin in=new Insulin();
            
            int ins=in.InsulinUnitsCalculation(userId, Integer.parseInt(carbs),bs);
         
            Diary d=new Diary();
            
            
            response.setContentType("application/json");
            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            
            jsonObjBuilder.add("insulin", ins);
            
            
            JsonObject jsonObj = jsonObjBuilder.build();
            
            
            
            
            try (PrintWriter out = response.getWriter()) {
                out.println(jsonObj);
            }
//
//        Map<String, Map<String, String>> meals = new HashMap<String, Map<String, String>>();
//        Map<String, String> foodCat = new HashMap<String, String>();
//        foodCat.put("potatoes", "Vegetablees");
//        foodCat.put("tomatoes", "Vegetablees");
//        foodCat.put("cucumber", "Vegetablees");
//        meals.put("moussaka", foodCat);


//         d.addToDiary(currentSugar,10+"","", ill, 2, mealType);
//       request.setAttribute("test", activity);
//        this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
//
/*
//////////////////code below its to fill up automaticly the food DB from text files
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
