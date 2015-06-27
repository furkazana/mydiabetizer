/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Diabetics;
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
}
