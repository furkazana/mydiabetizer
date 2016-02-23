/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Bb;
import ent.Bbed;
import ent.Bd;
import ent.Bl;
import ent.Bplus2;
import ent.Dplus2;
import ent.Lplus2;
import ent.Oob;
import ent.Random;
import ent.TimeSlots;

/**
 *
 * @author Rock n Roll
 */
class DiaryFactory
{
     public DiaryFactory()
    {
        
    }
    
    public TimeSlots getTimeSlots(String serType)
    {
          if(serType == null)
         {
         return null;
         }
         
         if(serType.equalsIgnoreCase("oobSL"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Oob();
         }
          if(serType.equalsIgnoreCase("bbSL") || serType.equalsIgnoreCase("bbINS") || serType.equalsIgnoreCase("bbNotes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bb();
         }
          if(serType.equalsIgnoreCase("b2SL") || serType.equalsIgnoreCase("b2INS") || serType.equalsIgnoreCase("b2Notes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bplus2();                                       
         } 
          if(serType.equalsIgnoreCase("blSL") || serType.equalsIgnoreCase("blINS") || serType.equalsIgnoreCase("blNotes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bl();
         }
            if(serType.equalsIgnoreCase("l2SL") || serType.equalsIgnoreCase("l2INS") || serType.equalsIgnoreCase("l2Notes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Lplus2();
         }
              if(serType.equalsIgnoreCase("bdSL") || serType.equalsIgnoreCase("bdINS") || serType.equalsIgnoreCase("bdNotes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bd();
         }
           if(serType.equalsIgnoreCase("d2SL") || serType.equalsIgnoreCase("d2INS") || serType.equalsIgnoreCase("d2Notes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Dplus2();
         }
          if(serType.equalsIgnoreCase("bbedSL") || serType.equalsIgnoreCase("bbedINS") || serType.equalsIgnoreCase("bbedNotes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bbed();
         }
          if(serType.equalsIgnoreCase("rSL") || serType.equalsIgnoreCase("rINS") || serType.equalsIgnoreCase("rNotes"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Random();
         }
         
          return null;
    }
    
         
  
    
}
