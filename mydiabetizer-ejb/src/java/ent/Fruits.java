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
@Table(name = "FRUITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fruits.findAll", query = "SELECT f FROM Fruits f"),
    @NamedQuery(name = "Fruits.findByFruitId", query = "SELECT f FROM Fruits f WHERE f.fruitId = :fruitId"),
    @NamedQuery(name = "Fruits.findByFruitTitle", query = "SELECT f FROM Fruits f WHERE f.fruitTitle = :fruitTitle"),
    @NamedQuery(name = "Fruits.findByFruitMeasurement", query = "SELECT f FROM Fruits f WHERE f.fruitMeasurement = :fruitMeasurement"),
    @NamedQuery(name = "Fruits.getHighestFrID", query = "SELECT MAX(f.fruitId) FROM Fruits f"),
    @NamedQuery(name = "Fruits.findByFruitGrams", query = "SELECT f FROM Fruits f WHERE f.fruitGrams = :fruitGrams"),
    @NamedQuery(name = "Fruits.findByFruitCarbs", query = "SELECT f FROM Fruits f WHERE f.fruitCarbs = :fruitCarbs")})
public class Fruits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRUIT_ID")
    private Integer fruitId;
    @Size(max = 32)
    @Column(name = "FRUIT_TITLE")
    private String fruitTitle;
    @Size(max = 50)
    @Column(name = "FRUIT_MEASUREMENT")
    private String fruitMeasurement;
    @Column(name = "FRUIT_GRAMS")
    private Integer fruitGrams;
    @Column(name = "FRUIT_CARBS")
    private Integer fruitCarbs;

    public Fruits() {
    }

    public Fruits(Integer fruitId) {
        this.fruitId = fruitId;
    }

    public Integer getFruitId() {
        return fruitId;
    }

    public void setFruitId(Integer fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitTitle() {
        return fruitTitle;
    }

    public void setFruitTitle(String fruitTitle) {
        this.fruitTitle = fruitTitle;
    }

    public String getFruitMeasurement() {
        return fruitMeasurement;
    }

    public void setFruitMeasurement(String fruitMeasurement) {
        this.fruitMeasurement = fruitMeasurement;
    }

    public Integer getFruitGrams() {
        return fruitGrams;
    }

    public void setFruitGrams(Integer fruitGrams) {
        this.fruitGrams = fruitGrams;
    }

    public Integer getFruitCarbs() {
        return fruitCarbs;
    }

    public void setFruitCarbs(Integer fruitCarbs) {
        this.fruitCarbs = fruitCarbs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fruitId != null ? fruitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fruits)) {
            return false;
        }
        Fruits other = (Fruits) object;
        if ((this.fruitId == null && other.fruitId != null) || (this.fruitId != null && !this.fruitId.equals(other.fruitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Fruits[ fruitId=" + fruitId + " ]";
    }
    
}
