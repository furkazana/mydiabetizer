/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics;

/**
 *
 * @author Rock n Roll
 */
public class Ratio
{ 
    final int rulle500=500;
    final int rulle1800=1800;
    final double killolMaths=0.55;
    private int tdi=0;//TDI Total daly insulin
    private int killograms=0;
    private String bodyType;

    public int calculatRatio()
    {   
        //500 ÷ Total Daily Insulin Dose = 1 unit insulin covers so many grams of carbohydrate
        //Total Daily Insulin Requirement (in units of insulin)= 0.55 X Total Weight in Kilograms
      
        return (int) (rulle500/(killograms * killolMaths));//return suggested ratio
     
    }
    public int calculateRatioIfUserProvideTDI()
    {
        
        if(tdi!=0)
         return (int) (rulle500/(tdi));//return ratio by user total daly doses insulin provided 
        
        return 0;
    }
      public double calculatCorectionFactor(int tdi)
    {
//        Formula for calculation of mg/dl from mmol/l: mg/dl = 18 × mmol/l
//        Formula for calculation of mmol/l from mg/dl: mmol/l = mg/dl / 18
//        Correction Factor = 1800 ÷Total Daily Insulin Dose = 1 unit of insulin will reduce the blood sugar so many mg/dl
        
        
        return (rulle1800/tdi)/18;
    }
    public int[] inputRatioHandler(int br, int  lu, int  di, int  general)
    {
        
        
        if(br==0)
            br=general;
        if(lu==0)
            lu=general;
        if(di==0)
            di=general;
        if(general==0 && ( br!=0 && lu!=0 && di!=0))
            general=(br+lu+di)/3;
        
      if((br==0 || lu==0 || di==0) && general!=0)
      {   
          if(br==0)
          br=general;
          if(lu==0)
          lu=general;
          if(di==0)
          di=general;
      }
      else if(br!= 0 && ( lu==0 || di==0 || general==0))
      {   
          if(lu==0)
          lu=br;
          if(di==0)
          di=br;
          if(general==0)
          general=br;
      }
       else if( lu!=0 && (br== 0 ||  di==0 || general==0))
      {  if(br==0) 
          br=lu;
         if(di==0)
          di=lu;
         if(general==0)
          general=lu;
      }
      else if((br== 0 || lu==0  || general==0) && di!=0)
      { 
          
         if(br==0) 
          br=di;
         if(lu==0)
          lu=di;
         if(general==0)
          general=di;
      }
      else if(br== 0 && lu==0  && general==0 && di==0)
      {
         int ratio = calculatRatio();
         int weightRatio= weightRatioAdjusment(this.killograms);
         int avarageRatio=(ratio+weightRatio)/2;
         int userRatio=calculateRatioIfUserProvideTDI();
         int avarageIfUserRatio=(ratio+weightRatio+userRatio)/3;
         if(avarageIfUserRatio==0)
         {
          br=avarageRatio;
          lu=avarageRatio;
          di=avarageRatio;
          general=avarageRatio;
         }
         else
         {
          br=avarageIfUserRatio;
          lu=avarageIfUserRatio;
          di=avarageIfUserRatio;
          general=avarageIfUserRatio;
         }
      }
       int returnArray[] ={br,lu,di,general};
        return returnArray;
    }
    public int weightRatioAdjusment(double kg)
    {
        if(kg<60)
        {
            return 30;
        }
       
        else if(kg>=60 && kg<80)
        {
            return 25;
        }
        else if(kg>=80 && kg<100)
        {
            return 20;
        }
        else if(kg>=100 && kg<120)
        {
            return 18;
        }
        else if(kg>=120 && kg<140)
        {
            return 15;
        }
        else if(kg>=140 && kg<170)
        {
            return 12;
        }
        else if(kg>=170 && kg<200)
        {
            return 10;
        }
        else if(kg>=200 && kg<230)
        {
            return 8;
        }
        else if(kg>=230 && kg<270)
        {
            return 6;
        }
        else if( kg >= 270)
        {
            return 5;
        }
//                less than 60	1:30
//                60-80	1:25
//                81-100	1:20
//                101-120	1:18
//                121-140	1:15
//                141-170	1:12
//                171-200	1:10
//                201-230	1:8
//                231-270	1:6
//                more than 270	1:5
        
        
        
        return 0;
        
    }
    
    
    
    public void updateRatio()
    {
        
    }
    
    
    
    
    public int getTdi() {
        return tdi;
    }

    public void setTdi(int tdi) {
        this.tdi = tdi;
    }

    public int getKillograms() {
        return killograms;
    }

    public void setKillograms(int killograms) {
        this.killograms = killograms;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    
    
    
}
