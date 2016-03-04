/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Fruits;
import ent.Meats;
import ent.Starches;
import ent.Vegetables;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rock n Roll
 */
@Local
public interface FoodHandlerBeanLocal {

    public void addVeg(Vegetables v);
    public void addFruits(Fruits f);
    public void addStarches(Starches s);
    public void addMeats(Meats m);
    public List<Fruits> getAllFruits();
    public List<Starches> getAllStarches();
    public List<Meats> getAllMeats();
    public List<Vegetables> getAllVegetables();
    
}
