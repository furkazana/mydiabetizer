/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Diabetics;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Rock n Roll
 */
@Local
public interface userBeanLocal 
{
    public Diabetics getDiabetic();
    public boolean isValidUsr(String email,String password);
    public void storeUser(String firstName,String lastName,String email,String password);

    /**
     *
     * @param email
     * @return
     */
    public Date getDate(String email);

}
