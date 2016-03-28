/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Userinfo;
import javax.ejb.Local;

/**
 *
 * @author Rock n Roll
 */
@Local
public interface AccountRationBeanLocal 
{
    public void addUserInfo(double kg,String bodytype,int tdi,String dob,int userId);
    public void addUserRatio(int id,int br,int lu,int di,int general);
    public void updateUserInfo(Userinfo ui);
    public void addOrUpdateUserInfo(Userinfo ui);
}
