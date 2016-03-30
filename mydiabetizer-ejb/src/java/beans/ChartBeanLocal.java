/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.ChartEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
@Local
public interface ChartBeanLocal {
    
    public List<ChartEntity> fetchAllBB(int userID);
    public List<ChartEntity> fetchAllB(int userID);
    
}
