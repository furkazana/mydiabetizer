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
        return (int) (rulle500/(killograms * killolMaths));
    }
    public int calculatCorectionFactor()
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
          br=ratio;
          lu=ratio;
          di=ratio;
          general=ratio;
      }
       int returnArray[] ={br,lu,di,general};
        return returnArray;
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
