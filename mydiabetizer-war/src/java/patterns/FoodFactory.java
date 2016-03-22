/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

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
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Rock n Roll
 */
public class FoodFactory
{

    FoodHandlerBeanLocal foodHandlerBean1 = lookupFoodHandlerBeanLocal();
   
    
   

    public FoodFactory()
    {
    }
    
  /*  public Food getFood(String type)
    {
       if(type == null)
         {
         return null;
         }
         
         if(type.equalsIgnoreCase("fatsAndSweets"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Fatsandsweets();
         } 
         if(type.equalsIgnoreCase("beverages"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Beverages();
         } 
         if(type.equalsIgnoreCase("meats"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Meats();
         } 
         if(type.equalsIgnoreCase("vegetables"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Vegetables();
         } 
         if(type.equalsIgnoreCase("fruits"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Fruits();
         } 
         if(type.equalsIgnoreCase("starches"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           return new Starches();
         } 
         return null;
    }*/
     public Food getMatch(String type,String product)
    {    Food food = null;
         if(type == null)
         {
         return null;
         }
          if(type.equalsIgnoreCase("fatsAndSweets"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         { 
            
           List<Fatsandsweets> FatsandsweetsList = foodHandlerBean1.getAllFatsandsweets();
           for(int i=0;i<FatsandsweetsList.size();i++)
           {
               if(product.equalsIgnoreCase(FatsandsweetsList.get(i).getFnsTitle()))
               {
                   food=FatsandsweetsList.get(i);
               }
               
           }
          return food;
          }
           if(type.equalsIgnoreCase("beverages"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         { 
            
          List<Beverages> BeveragesList = foodHandlerBean1.getAllBeverages(); 
           for(int i=0;i<BeveragesList.size();i++)
           {
               if(product.equalsIgnoreCase(BeveragesList.get(i).getBevTitle()))
               {
                   food=BeveragesList.get(i);
               }
               
           }
         return food;
          }
           if(type.equalsIgnoreCase("meats"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
            List<Meats> meatsList = foodHandlerBean1.getAllMeats(); 
           for(int i=0;i<meatsList.size();i++)
           {
               if(product.equalsIgnoreCase(meatsList.get(i).getMeatTitle()))
               {
                   food=meatsList.get(i);
               }
               
           }
           return food;
         } 
            if(type.equalsIgnoreCase("vegetables"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         
            List<Vegetables> vegList = foodHandlerBean1.getAllVegetables();
           for(int i=0;i<vegList.size();i++)
           {
               if(product.equalsIgnoreCase(vegList.get(i).getVegTitle()))
               {
                   food=vegList.get(i);
               }
               
           }
           return food;
         } 
            if(type.equalsIgnoreCase("fruits"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
          
            List<Fruits> fruitsList = foodHandlerBean1.getAllFruits();
           for(int i=0;i<fruitsList.size();i++)
           {
               if(product.equalsIgnoreCase(fruitsList.get(i).getFruitTitle()))
               {
                   food=fruitsList.get(i);
               }
               
           }
           return food;
         } 
         if(type.equalsIgnoreCase("starches"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         
            List<Starches> starchesList = foodHandlerBean1.getAllStarches();
           for(int i=0;i<starchesList.size();i++)
           {
               if(product.equalsIgnoreCase(starchesList.get(i).getStarchTitle()))
               {
                   food=starchesList.get(i);
               }
               
           }
           return food;
         } 
        return food;
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
    

          /*
         if(type.equalsIgnoreCase("beverages"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           Food food = null;
            List<Beverages> BeveragesList = foodHandlerBean.getAllBeverages(); 
           for(int i=0;i<BeveragesList.size();i++)
           {
               if(type.equalsIgnoreCase(BeveragesList.get(i).getBevTitle()))
               {
                   food=BeveragesList.get(i);
               }
               
           }
           return food;
         } 
         if(type.equalsIgnoreCase("meats"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
            Food food = null;
            List<Meats> meatsList = foodHandlerBean.getAllMeats(); 
           for(int i=0;i<meatsList.size();i++)
           {
               if(type.equalsIgnoreCase(meatsList.get(i).getMeatTitle()))
               {
                   food=meatsList.get(i);
               }
               
           }
           return food;
         } 
         if(type.equalsIgnoreCase("vegetables"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           Food food = null;
            List<Vegetables> vegList = foodHandlerBean.getAllVegetables();
           for(int i=0;i<vegList.size();i++)
           {
               if(type.equalsIgnoreCase(vegList.get(i).getVegTitle()))
               {
                   food=vegList.get(i);
               }
               
           }
           return food;
         } 
         if(type.equalsIgnoreCase("fruits"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           Food food = null;
            List<Fruits> fruitsList = foodHandlerBean.getAllFruits();
           for(int i=0;i<fruitsList.size();i++)
           {
               if(type.equalsIgnoreCase(fruitsList.get(i).getFruitTitle()))
               {
                   food=fruitsList.get(i);
               }
               
           }
           return food;
         } 
         if(type.equalsIgnoreCase("starches"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
           Food food = null;
            List<Starches> starchesList = foodHandlerBean.getAllStarches();
           for(int i=0;i<starchesList.size();i++)
           {
               if(type.equalsIgnoreCase(starchesList.get(i).getStarchTitle()))
               {
                   food=starchesList.get(i);
               }
               
           }
           return food;
         } 
         return null;
    }*/

//    private FoodHandlerBeanLocal lookupFoodHandlerBeanLocal() {
//        try {
//            Context c = new InitialContext();
//            return (FoodHandlerBeanLocal) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/FoodHandlerBean!beans.FoodHandlerBeanLocal");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
    
    
    
    

