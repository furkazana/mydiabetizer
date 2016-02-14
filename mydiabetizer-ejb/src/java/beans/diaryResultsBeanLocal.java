/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author Rock n Roll
 */
@Local
public interface diaryResultsBeanLocal 
{
     public void addUserAndDate(int id);
    
}
