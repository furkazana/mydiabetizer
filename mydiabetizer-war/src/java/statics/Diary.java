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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.servlet.http.HttpSession;
import patterns.DiaryFactory;

/**
 *
 * @author Rock n Roll
 */
public class Diary 
{

    diaryDatesBean diaryDatesBean = lookupdiaryDatesBeanBean();
    
    
    
    public void addToDiary(String sugar,String insulin,String note,String ill,int id,String type)         
    {

        
        String time="";
        int qur=0;
        
        if(type.equalsIgnoreCase("Breakfast"))
        {
            time="bbSL";
            qur=1;
        }
        if(type.equalsIgnoreCase("Lunch"))
        {
            time="blSL";
            qur=3;
        }
         if(type.equalsIgnoreCase("Dinner"))
        {
            time="bdSL";
            qur=5;
        }
         if(type.equalsIgnoreCase("Snack"))
        {
            time="rSL";
            qur=8;
        }
        
        Diarydates diaryDateAndUser = null;
              //checks if there is already results for that user for this current date
            diaryDateAndUser =  diaryDatesBean.resultExistForTheDay(id);
            if(diaryDateAndUser==null) 
            { //if there is no result found ad result for the user and the current date 
              diaryDateAndUser= diaryDatesBean.addUserAndDate(id,ill);
            }
          
            //loop though all the inputs fields and if there is an input adding it to the DB
         //    for(int i=0 ;i<daylyresults.length;i++)
                //    {
             //check if there is already result for the time slot for the user for the current date
             //if there is already an input not doing anything
             if(diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(), qur))//hard coding diaryDatesBean.isTimeLine(diaryDateAndUser.getDiarydateId(),1
                {    
                    
                   
                   
                        Double convertedSugar;
                        int convertedInsulin;
                        
//                        String sugar = request.getParameter(daylyresults[i]);
//                        String insulin = request.getParameter(daylyresults[i+1]);//hard coding
//                        String note = request.getParameter(daylyresults[i+2]);
                        
                        if(insulin.equals(""))//catch exception if there is no input and set it up to 0
                        { convertedInsulin=0;}
                        else
                        {   //trowing error if the input is double//exception needs to be considered and refer to an error
                            convertedInsulin=Integer.parseInt(insulin); }//if there is input converted it.//this
                        
                        if(sugar.equals(""))
                        { convertedSugar=0.0;}
                        else
                        { convertedSugar=Double.parseDouble(sugar); }
                        
                      if(convertedInsulin!=0 || convertedSugar!=0 )
                      {   
                       
                      
                          DiaryFactory dFactory=new DiaryFactory();
                          TimeSlots o = dFactory.getTimeSlots(time);
                 
                          o.setSugar(convertedSugar);
                          o.setInsulin(convertedInsulin);
                          
                        diaryDatesBean.addSingleLineResult(o,diaryDateAndUser,time);
                      }
                    
                    }
    }
       //  }
   // }List<List> timeList=new List<ArrayList>();
     public ArrayList<ArrayList<ChartEntity>> timeList(List<ChartEntity> enteties) throws ParseException
     {
         
         ArrayList<ArrayList<ChartEntity>> listOLists = new ArrayList<ArrayList<ChartEntity>>();
         ArrayList<ChartEntity> sixToTwelve=new ArrayList<ChartEntity>();
         ArrayList<ChartEntity> TwelveToEighteen=new ArrayList<ChartEntity>();
         ArrayList<ChartEntity> EighteenToZero=new ArrayList<ChartEntity>();
         ArrayList<ChartEntity> ZeroToSix=new ArrayList<ChartEntity>();
         
         
         
         String six = "06:00:00";
         String twelve = "12:00:00";
         String eighteen = "18:00:00";
         String zero ="00:00:00";
       //  String Compare ="13:56:01";        

        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date dateSix = sdf.parse(six);
        Date dateTwelve = sdf.parse(twelve);
        Date dateEighteen = sdf.parse(eighteen);
        Date dateZero = sdf.parse(zero);
        //Date dateToCompare = sdf.parse(Compare);
        
         for(int i=0;i<enteties.size();i++)
         {    
               String Compare =enteties.get(i).getTime().trim();
               Date dateToCompare = sdf.parse(Compare);
           
         if((dateToCompare.after(dateSix) && dateToCompare.before(dateTwelve)) || enteties.get(i).getDate().trim().equalsIgnoreCase(six) )
         { 
             sixToTwelve.add(enteties.get(i));
         }
         if((dateToCompare.after(dateTwelve) && dateToCompare.before(dateEighteen)) || enteties.get(i).getDate().trim().equalsIgnoreCase(twelve) )
         { 
             TwelveToEighteen.add(enteties.get(i));
         }
          if((dateToCompare.after(dateEighteen) && dateToCompare.before(dateZero)) || enteties.get(i).getDate().trim().equalsIgnoreCase(eighteen) )
         { 
             EighteenToZero.add(enteties.get(i));
         }
           if((dateToCompare.after(dateZero) && dateToCompare.before(dateSix)) || enteties.get(i).getDate().trim().equalsIgnoreCase(zero) )
         { 
             ZeroToSix.add(enteties.get(i));
         }
         }
         listOLists.add(sixToTwelve);
         listOLists.add(TwelveToEighteen);
         listOLists.add(EighteenToZero);
         listOLists.add(ZeroToSix);
        //System.out.println("Time: " + sdf.format(date));
         
         
        
         
        
         
         return listOLists;
     }

    
    public JsonObject getJsonCustom(List<ChartEntity> enteties ) throws ParseException
     {
         String six = "06:00:00";
         String twelve = "12:00:00";
         String eighteen = "18:00:00";
         String zero ="00:00:00";
       //  String Compare ="13:56:01";        

        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date dateSix = sdf.parse(six);
        Date dateTwelve = sdf.parse(twelve);
        Date dateEighteen = sdf.parse(eighteen);
        Date dateZero = sdf.parse(zero);
         
         
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder1 = Json.createArrayBuilder();
        JsonArrayBuilder arrayBuilder2 = Json.createArrayBuilder();
        JsonArrayBuilder arrayBuilder3 = Json.createArrayBuilder();
        JsonArrayBuilder arrayBuilder4 = Json.createArrayBuilder();
        
        JsonArray sixToTwelve;
        JsonArray TwelveToEighteen;
        JsonArray EighteenToZero;
        JsonArray ZeroToSix;
        String convertedDate="";
        for(int i=0;i<enteties.size();i++)
         {     
               convertedDate=enteties.get(i).getDate().trim();
               convertedDate.replaceAll("/", "-");
               String Compare =enteties.get(i).getTime().trim();
               Date dateToCompare = sdf.parse(Compare);
           
         if((dateToCompare.after(dateSix) && dateToCompare.before(dateTwelve)) || enteties.get(i).getDate().trim().equalsIgnoreCase(six) )
         { 
              
              arrayBuilder1.add(jsonObjBuilder.add("date", enteties.get(i).getDate()).add("value", enteties.get(i).getSugar()));
             // sixToTwelve.add(enteties.get(i));
         }
         if((dateToCompare.after(dateTwelve) && dateToCompare.before(dateEighteen)) || enteties.get(i).getDate().trim().equalsIgnoreCase(twelve) )
         { 
            arrayBuilder2.add(jsonObjBuilder.add("date", enteties.get(i).getDate()).add("value", enteties.get(i).getSugar()));
         }
          if((dateToCompare.after(dateEighteen) && dateToCompare.before(dateZero)) || enteties.get(i).getDate().trim().equalsIgnoreCase(eighteen) )
         { 
            arrayBuilder3.add(jsonObjBuilder.add("date", enteties.get(i).getDate()).add("value", enteties.get(i).getSugar()));
         }
           if((dateToCompare.after(dateZero) && dateToCompare.before(dateSix)) || enteties.get(i).getDate().trim().equalsIgnoreCase(zero) )
         { 
             arrayBuilder4.add(jsonObjBuilder.add("date", enteties.get(i).getDate()).add("value", enteties.get(i).getSugar()));
         }
         }
          sixToTwelve=arrayBuilder1.build();
          TwelveToEighteen=arrayBuilder2.build();
          EighteenToZero=arrayBuilder3.build();
          ZeroToSix=arrayBuilder4.build();
       
        
      //  ja = arrayBuilder.build();
        
        JsonObject jsonObj = (JsonObject) jsonObjBuilder.add("sixToTwelve", sixToTwelve)
                              .add("TwelveToEighteen", TwelveToEighteen)
                              .add("EighteenToZero", EighteenToZero)
                              .add("ZeroToSix", ZeroToSix);
         
         
         return null;
     }
    private diaryDatesBean lookupdiaryDatesBeanBean() {
        try {
            Context c = new InitialContext();
            return (diaryDatesBean) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/diaryDatesBean!beans.diaryDatesBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
