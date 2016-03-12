/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Beverages;
import ent.Fatsandsweets;
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
    public void addBeverages(Beverages b);
    public List<Beverages> getAllBeverages();
    public void addFatsandsweets(Fatsandsweets b);
    public List<Fatsandsweets> getAllFatsandsweets();
    public List<Fruits> getAllFruits();
    public List<Starches> getAllStarches();
    public List<Meats> getAllMeats();
    public List<Vegetables> getAllVegetables();
    
}
