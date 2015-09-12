/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import controllers.EncryptionControl;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rock n Roll
 */
public class EncrAlgs implements EncryptionControl
{
    private String password;
    private String hexPassword;

    public String getHexPassword() {
        return hexPassword;
    }

    public EncrAlgs(String password)
    {
        this.password = password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void run()
    {
        try 
        {
             this.hexPassword=new FirstRoundEncryption().start(this.password);
             this.hexPassword+=new TokenEncryption().start();
             for(int i=0;i<2000;i++)
             {
              this.hexPassword=new lastRound().start(this.hexPassword);    
             }
             
        } 
        catch (Exception ex)
        {
            Logger.getLogger(EncrAlgs.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void check(Date date)
    {
        try 
        {
             this.hexPassword=new FirstRoundEncryption().start(this.password);
             this.hexPassword+=new TokenEncryption().check(date);
             for(int i=0;i<2000;i++)
             {
              this.hexPassword=new lastRound().start(this.hexPassword);    
             }
             
        } 
        catch (Exception ex)
        {
            Logger.getLogger(EncrAlgs.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
}
