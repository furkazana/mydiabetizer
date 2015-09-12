/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;

/**
 *
 * @author Rock n Roll
 */
public interface EncryptionControl
{
    
    
    
  
    public void run();

    public String getHexPassword();

    

    public void check(Date date);
}
