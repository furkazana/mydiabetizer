/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics;

import beans.diaryDatesBean;
import ent.ChartEntity;
import ent.Diarydates;
import ent.TimeSlots;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import patterns.DiaryFactory;

/**
 *
 * @author Rock n Roll
 */
public class Diary {

    diaryDatesBean diaryDatesBean = lookupdiaryDatesBeanBean();
    List<ChartEntity> printList;
    public List<ChartEntity> getPrintList() {
        return printList;
    }
    public void addToDiary(String sugar, String insulin, String note, String ill, int id, String type) {

        String time = "";
        int qur = 0;

        if (type.equalsIgnoreCase("Breakfast")) {
            time = "bbSL";
            qur = 1;
        }
        if (type.equalsIgnoreCase("Lunch")) {
            time = "blSL";
            qur = 3;
        }
        if (type.equalsIgnoreCase("Dinner")) {
            time = "bdSL";
            qur = 5;
        }
        if (type.equalsIgnoreCase("Snack")) {
            time = "rSL";
            qur = 8;
        }

        Diarydates diaryDateAndUser = null;
        //checks if there is already results for that user for this current date
        diaryDateAndUser = diaryDatesBean.resultExistForTheDay(id);
        if (diaryDateAndUser == null) { //if there is no result found ad result for the user and the current date 
            diaryDateAndUser = diaryDatesBean.addUserAndDate(id, ill);
        }

        //loop though all the inputs fields and if there is an input adding it to the DB
        //    for(int i=0 ;i<daylyresults.length;i++)
        //    {
        //check if there is already result for the time slot for the user for the current date
        //if there is already an input not doing anything
        if (diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(), qur))//hard coding diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(),1
        {

            Double convertedSugar;
            int convertedInsulin;

//                        String sugar = request.getParameter(daylyresults[i]);
//                        String insulin = request.getParameter(daylyresults[i+1]);//hard coding
//                        String note = request.getParameter(daylyresults[i+2]);
            if (insulin.equals(""))//catch exception if there is no input and set it up to 0
            {
                convertedInsulin = 0;
            } else {   //trowing error if the input is double//exception needs to be considered and refer to an error
                convertedInsulin = Integer.parseInt(insulin);
            }//if there is input converted it.//this

            if (sugar.equals("")) {
                convertedSugar = 0.0;
            } else {
                convertedSugar = Double.parseDouble(sugar);
            }

            if (convertedInsulin != 0 || convertedSugar != 0) {

                DiaryFactory dFactory = new DiaryFactory();
                TimeSlots o = dFactory.getTimeSlots(time);

                o.setSugar(convertedSugar);
                o.setInsulin(convertedInsulin);

                diaryDatesBean.addSingleLineResult(o, diaryDateAndUser, time);
            }

        }
    }
    

   
    public JsonObject getJsonCustom1(List<List<ChartEntity>> enteties) throws ParseException 
    {
         List<ChartEntity> sixToTwleve = enteties.get(0);
         List<ChartEntity> twleveToEighteen = enteties.get(1);
         List<ChartEntity> eighteenToZero = enteties.get(2);
         List<ChartEntity> zeroToSix = enteties.get(3);
        JsonObject jsonObj = null;
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        
        jsonObjBuilder.add("sixToTwleve", buildJsonArray(sixToTwleve));
        jsonObjBuilder.add("twleveToEighteen", buildJsonArray(twleveToEighteen));
        jsonObjBuilder.add("eighteenToZero", buildJsonArray(eighteenToZero));
        jsonObjBuilder.add("zeroToSix", buildJsonArray(zeroToSix));
        jsonObj = jsonObjBuilder.build();
        return jsonObj;
    }
     private JsonArray buildJsonArray(List<ChartEntity> list) 
    {
        String date= "";
      ArrayList< String> blackList= new  ArrayList< String>();
      JsonObject jsonObj = null;
      JsonArray jsonArray = null;
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        double avarage;
        for(int t=0;t<list.size();t++)
        {   
            if(blackList.contains(list.get(t).getDate())) {
                continue;
            }
            String test = ""; 
            avarage = list.get(t).getSugar();
           
            int counter=1;
            for(int y=t+1;y<list.size();y++)
            {      
                   
                
                if(list.get(t).getDate().equalsIgnoreCase(list.get(y).getDate()))
                 {
                         avarage += list.get(y).getSugar();
                        
                         counter++;
                 }
            }
            blackList.add(list.get(t).getDate());
            ChartEntity a=new ChartEntity();
            a=list.get(t);
            a.setSugar(avarage);
            DecimalFormat df = new DecimalFormat("#.##");
            jsonArrayBuilder.add(jsonObjBuilder.add("date", a.getDate()).add("value", df.format(a.getSugar())).build());
        }
        
        jsonArray = jsonArrayBuilder.build();
        return jsonArray;
        
    }
   

    private diaryDatesBean lookupdiaryDatesBeanBean() {
        try {
            Context c = new InitialContext();
            return (diaryDatesBean) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/diaryDatesBean!beans.diaryDatesBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }}


