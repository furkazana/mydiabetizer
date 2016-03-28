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
    
    
    public String Run(String data,String ill,String activ)
    {  FoodFactory fh = new FoodFactory();
         
        String [] eachLine=data.split(";");//split line by line
        int percentRatio=0;
        int carbsInMeal=0;
        for (String eachLine1 : eachLine) 
       {
              //FatsAndSweets:Butter: - 123;FatsAndSweets:Butter: - 123;FatsAndSweets:Cheese,blue: - 123;FatsAndSweets:Cheese,cheddar: - 123
           
            String[] line = eachLine1.split(":");//split each line by Group-type and food-title
           // String[] line = eachLine[0].split(":");
          
           String r;
                  r = line[0].replace("undefined","");//remove undefined from the begining of the string
           Food food = fh.getMatch(r.trim(),line[1].trim());//trimp to remove whitespaces beffore and after thr strings
        
            int grams=food.getGrams();
            int carbs=food.getCarbs();
           if(grams!=0 && carbs!=0)//catching Arithmetic exceptions ddevide by 0
           {
            percentRatio=grams/carbs;
            int calculatedCarbs=Integer.parseInt(line[2])/percentRatio;
            carbsInMeal+=calculatedCarbs;
           }
       }
        return carbsInMeal+"";
    }
   public String tripString(String data)
   {
      // data=data.replaceAll("\\s","");
       
       String r="";
       
        String [] eachLine=data.split(";");//split line by line
      
        for (int i=0;i<eachLine.length;i++) 
       {
            String[] line = eachLine[i].split(":");//split each line by Group-type and food-title
           // String[] line = eachLine[0].split(":");
          
          if(i==eachLine.length-1)
          {
           r+=line[0]+":"+line[1].trim()+":"+" - "+line[2];   
          }
          else
           r+=line[0]+":"+line[1].trim()+":"+" - "+line[2]+";";
          //        r = line[0].replace("undefined","");//remove undefined from the begining of the string
         //  Food food = fh.getMatch(r.trim(),line[1].trim());//trimp to remove whitespaces beffore and after thr strings
       }
        return r;
        
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
///