/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statics;

import beans.AccountRationBeanLocal;
import ent.Userinfo;
import ent.Userratios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Rock n Roll
 */
public class Insulin
{

    AccountRationBeanLocal accountRationBean = lookupAccountRationBeanLocal();
   
    
    
    
    public Insulin() 
    {
        
    }

    public int InsulinUnitsCalculation(int userid,int carbs,double currentSugarLevel)
    {
              Userratios uri = new Userratios();
              uri  = accountRationBean.getUsersRatios(userid);  
              Userinfo inf   = new Userinfo();
              inf = accountRationBean.getUsersIfo(userid);
              int tdi = inf.getTotalInsulinD();
              int additonalUnitns=getHBSR(tdi,currentSugarLevel);
        
        return (int) ((carbs / (int) uri.getGeneral())+additonalUnitns);
    }
    private int getHBSR(int tdi,double currentSugarLevel)
    {
        Ratio r=new Ratio();
        double hbsRatio=r.calculatCorectionFactor(tdi);//return the ratio for HBSR in mmol
        double difference=0;  
        if(currentSugarLevel>6.7)//only if the current sugar is higher then the target level in mmol
        {  
            difference=currentSugarLevel-6.7;//the difference bettwen current sugar levels and the target 6.7 
    
            return (int)(difference/hbsRatio);//return in units of insulin if needs adjusment!
           
           
        }
       return 0;//return 0 if no adjusment needed
    }
    
    
    private AccountRationBeanLocal lookupAccountRationBeanLocal() {
        try {
            Context c = new InitialContext();
            return (AccountRationBeanLocal) c.lookup("java:global/mydiabetizer/mydiabetizer-ejb/AccountRationBean!beans.AccountRationBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
}
