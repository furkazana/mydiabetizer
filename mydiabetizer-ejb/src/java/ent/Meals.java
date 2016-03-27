/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rock n Roll
 */
@Entity
@Table(name = "MEALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meals.findAll", query = "SELECT m FROM Meals m"),
    @NamedQuery(name = "Meals.findByMealId", query = "SELECT m FROM Meals m WHERE m.mealId = :mealId"),
    @NamedQuery(name = "Meals.findHighestMealId", query = "SELECT max(m.mealId) FROM Meals m"),
    @NamedQuery(name = "Meals.findByUserId", query = "SELECT m FROM Meals m WHERE m.userId = :userId"),
    @NamedQuery(name = "Meals.findByMealName", query = "SELECT m FROM Meals m WHERE m.mealName = :mealName")})
public class Meals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEAL_ID")
    private Integer mealId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEAL_NAME")
    private String mealName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "MEAL_INGREDIENS")
    private String mealIngrediens;

    public Meals() {
    }

    public Meals(Integer mealId) {
        this.mealId = mealId;
    }

    public Meals(Integer mealId, int userId, String mealName, String mealIngrediens) {
        this.mealId = mealId;
        this.userId = userId;
        this.mealName = mealName;
        this.mealIngrediens = mealIngrediens;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealIngrediens() {
        return mealIngrediens;
    }

    public void setMealIngrediens(String mealIngrediens) {
        this.mealIngrediens = mealIngrediens;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealId != null ? mealId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meals)) {
            return false;
        }
        Meals other = (Meals) object;
        if ((this.mealId == null && other.mealId != null) || (this.mealId != null && !this.mealId.equals(other.mealId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Meals[ mealId=" + mealId + " ]";
    }
    
}
