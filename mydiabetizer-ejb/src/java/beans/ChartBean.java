/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.ChartEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
@Stateless
public class ChartBean implements ChartBeanLocal 
{ 

    @Override
    public List<ChartEntity> fetchAllBB(int userID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChartEntity> fetchAllB(int userID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
