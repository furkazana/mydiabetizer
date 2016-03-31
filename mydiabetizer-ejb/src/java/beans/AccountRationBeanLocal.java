/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.TimeSlots;
import ent.Userinfo;
import ent.Userratios;
import java.util.ArrayList;
import java.util.List;
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
    public Userratios getUsersRatios(int id);
    public Userinfo getUsersIfo(int id);
    public List<ArrayList<TimeSlots>> getBreakfast(int userId);
    public List<ArrayList<TimeSlots>> getLunch(int userId);
    public List<ArrayList<TimeSlots>> getDiner(int userId);
}
