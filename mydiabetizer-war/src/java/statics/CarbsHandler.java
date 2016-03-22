/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics;

import beans.FoodHandlerBeanLocal;
import ent.Beverages;
import ent.Fatsandsweets;
import ent.Food;
import ent.Fruits;
import ent.Meats;
import ent.Starches;
import ent.Vegetables;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import patterns.FoodFactory;
import servlets.FoodHandler;

/**
 *
 * @author Rock n Roll
 */
public class CarbsHandler 
{

    FoodHandlerBeanLocal foodHandlerBean = lookupFoodHandlerBeanLocal();
//    
//         List<Fruits> fruitsList; 
//      
//        List<Starches> starchesList;
//        
//        List<Meats> meatsList;
//       
//        List<Vegetables> vegList;
//    
//        List<Fatsandsweets> FatsandsweetsList;
//       
//        List<Beverages> BeveragesList ;
        
    public CarbsHandler()
    {
//        fruitsList = foodHandlerBean.getAllFruits();
//        starchesList = foodHandlerBean.getAllStarches();
//        meatsList = foodHandlerBean.getAllMeats();
//        vegList = foodHandlerBean.getAllVegetables();
//        FatsandsweetsList = foodHandlerBean.getAllFatsandsweets();
//        BeveragesList = foodHandlerBean.getAllBeverages();
    }
    
    
    public String Run(String data)
    {  FoodFactory fh = new FoodFactory();
         String s="";
        String [] eachLine=data.split(";");
        int percentRatio=0;
        int carbsInMeal=0;
        for (String eachLine1 : eachLine) 
       {
            //String[] line = eachLine1.split(":");
            String[] line = eachLine[0].split(":");
          // Food food= fh.getFood(line[0]);
           Food food = fh.getMatch(line[0].trim(),line[1].trim());//trimp to remove whitespaces beffore and after thr strings
           // s=line[0].replaceAll("\\s+","");
          //  s=food.getTitle();
         //  int i=food;
            int grams=food.getGrams();
            int carbs=food.getCarbs();
           if(grams!=0 && carbs!=0)//catching Arithmetic exceptions ddevide by 0
           {
            percentRatio=grams/carbs;
            int calculatetCarbs=Integer.parseInt(line[2])/percentRatio;
            carbsInMeal+=calculatetCarbs;
           }
       }
        return carbsInMeal+"";
    }
   
    private FoodHandlerBeanLocal lookupFoodHandlerBeanLocal() {
        try {
            Context c = new InitialContext();
            return (FoodHandlerBeanLocal) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/FoodHandlerBean!beans.FoodHandlerBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
