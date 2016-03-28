/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AccountRationBeanLocal;
import ent.Userinfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import statics.Ratio;

/**
 *
 * @author Rock n Roll
 */
public class AccountHandler extends HttpServlet 
{

    @EJB
    private AccountRationBeanLocal accountRationBean;
     
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Userinfo ui=new Userinfo();
        ui.setUserId(2);
        ui.setKg(80.0);
        ui.setTotalInsulinD(25);
        ui.setBodyType("slim");
        
        
        
       accountRationBean.updateUserInfo(ui);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        JsonReader jr = Json.createReader(request.getInputStream());
        JsonObject jo = jr.readObject();
        JsonObject accountData = jo.getJsonObject("postData");
        String kg="";
        int userIdHard=3;
        kg = accountData.getString("kg");
          String bodyType = "";
          String rapidDoses = "";
          String dateOfBirth = "";
          String breakfastRatio = "";
          String lunchRatio = "";
          String dinnerRatio = "";
          String generalRatio = "";
          int br=0;
          int lu=0;
          int di=0;
          int general=0;
          
 try {
         
           bodyType = accountData.getString("bodyType");
           rapidDoses = accountData.getString("rapidDoses");
           dateOfBirth = accountData.getString("dateOfBirth");
           breakfastRatio = accountData.getString("breakfastRatio");
           lunchRatio = accountData.getString("lunchRatio");
           dinnerRatio = accountData.getString("dinnerRatio");
           generalRatio = accountData.getString("generalRatio");
     } 
 catch(NullPointerException e)
 {
   
 }      
        if(!breakfastRatio.equalsIgnoreCase("") && !breakfastRatio.equalsIgnoreCase(" ") )
        {
            br= Integer.parseInt(breakfastRatio);
        }
        if(!lunchRatio.equalsIgnoreCase("") && !lunchRatio.equalsIgnoreCase(" ") )
        {
            lu= Integer.parseInt( lunchRatio);
        }
         if(!dinnerRatio.equalsIgnoreCase("") && !dinnerRatio.equalsIgnoreCase(" ") )
        {
            di=  Integer.parseInt(dinnerRatio);
        }
         if(!generalRatio.equalsIgnoreCase("") && !generalRatio.equalsIgnoreCase(" ") )
        {
            general=  Integer.parseInt(generalRatio);
        }
        
        String test =kg+"-"+bodyType+"-"+rapidDoses+"-"+dateOfBirth+"-"+breakfastRatio+"-"+lunchRatio+"-"+
                    dinnerRatio+"-"+generalRatio;
        
        Ratio r =new Ratio();
        r.setBodyType(bodyType);
        r.setKillograms(Integer.parseInt(kg));
        r.setTdi(Integer.parseInt(rapidDoses));
        
        int ratios[]= r.inputRatioHandler(br, lu, di, general);
        accountRationBean.addUserRatio(userIdHard, ratios[0], ratios[1], ratios[2], ratios[3]);
        
        Userinfo ui=new Userinfo();
        ui.setUserId(userIdHard);
        ui.setKg(Integer.parseInt(kg));
        ui.setTotalInsulinD(Integer.parseInt(rapidDoses));
        ui.setBodyType(bodyType);
        
        accountRationBean.addOrUpdateUserInfo(ui);
        
        String test1=ratios[0]+"-"+ ratios[1]+"-"+ ratios[2]+"-"+ratios[3];
        request.setAttribute("test", test1);
        this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
