/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import ent.Bb;
import ent.Bplus2;
import ent.Oob;
import ent.TimeSlots;
import java.io.Serializable;

/**
 *
 * @author Rock n Roll
 */
public class DiaryFactory 
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
          if(serType.equalsIgnoreCase("b2SL"))//return OOB if any of the oob fields returns not null///taking the string of the suger input to creat te object
         {
         return new Bplus2();
         }
         
         
         
         
          return null;
    }
    
}
