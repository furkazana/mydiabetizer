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
@Table(name = "BEVERAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beverages.findAll", query = "SELECT b FROM Beverages b"),
    @NamedQuery(name = "Beverages.findByBevId", query = "SELECT b FROM Beverages b WHERE b.bevId = :bevId"),
    @NamedQuery(name = "Beverages.getHighestBevID", query = "SELECT MAX(b.bevId) FROM Beverages b"),
    @NamedQuery(name = "Beverages.findByBevTitle", query = "SELECT b FROM Beverages b WHERE b.bevTitle = :bevTitle"),
    @NamedQuery(name = "Beverages.findByBevMeasurement", query = "SELECT b FROM Beverages b WHERE b.bevMeasurement = :bevMeasurement"),
    @NamedQuery(name = "Beverages.findByBevGrams", query = "SELECT b FROM Beverages b WHERE b.bevGrams = :bevGrams"),
    @NamedQuery(name = "Beverages.findByBevCarbs", query = "SELECT b FROM Beverages b WHERE b.bevCarbs = :bevCarbs")})
public class Beverages extends Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BEV_ID")
    private Integer bevId;
    @Size(max = 50)
    @Column(name = "BEV_TITLE")
    private String bevTitle;
    @Size(max = 50)
    @Column(name = "BEV_MEASUREMENT")
    private String bevMeasurement;
    @Column(name = "BEV_GRAMS")
    private Integer bevGrams;
    @Column(name = "BEV_CARBS")
    private Integer bevCarbs;

    public Beverages() {
    }

    public Beverages(Integer bevId) {
        this.bevId = bevId;
    }

    public Integer getBevId() {
        return bevId;
    }

    public void setBevId(Integer bevId) {
        this.bevId = bevId;
    }

    public String getBevTitle() {
        return bevTitle;
    }

    public void setBevTitle(String bevTitle) {
        this.bevTitle = bevTitle;
    }

    public String getBevMeasurement() {
        return bevMeasurement;
    }

    public void setBevMeasurement(String bevMeasurement) {
        this.bevMeasurement = bevMeasurement;
    }

    public Integer getBevGrams() {
        return bevGrams;
    }

    public void setBevGrams(Integer bevGrams) {
        this.bevGrams = bevGrams;
    }

    public Integer getBevCarbs() {
        return bevCarbs;
    }

    public void setBevCarbs(Integer bevCarbs) {
        this.bevCarbs = bevCarbs;
    }
    @Override
     public int getId() {
        return bevId;
    }

    @Override
    public String getTitle() {
        return bevTitle;
    }
    @Override
    public String getMesurments() {
        return bevMeasurement;
    }
    @Override
    public int getCarbs() {
        return bevCarbs;
    }
    @Override
    public int getGrams() {
        return bevGrams;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bevId != null ? bevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beverages)) {
            return false;
        }
        Beverages other = (Beverages) object;
        if ((this.bevId == null && other.bevId != null) || (this.bevId != null && !this.bevId.equals(other.bevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Beverages[ bevId=" + bevId + " ]";
    }
    
}
