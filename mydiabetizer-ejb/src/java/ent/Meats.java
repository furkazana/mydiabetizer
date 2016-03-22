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
@Table(name = "MEATS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meats.findAll", query = "SELECT m FROM Meats m"),
    @NamedQuery(name = "Meats.findByMeatId", query = "SELECT m FROM Meats m WHERE m.meatId = :meatId"),
    @NamedQuery(name = "Meats.findByMeatTitle", query = "SELECT m FROM Meats m WHERE m.meatTitle = :meatTitle"),
    @NamedQuery(name = "Meats.getHighestMeatID", query = "SELECT MAX(m.meatId) FROM Meats m"),
    @NamedQuery(name = "Meats.findByMeatMeasurements", query = "SELECT m FROM Meats m WHERE m.meatMeasurements = :meatMeasurements"),
    @NamedQuery(name = "Meats.findByMeatGrams", query = "SELECT m FROM Meats m WHERE m.meatGrams = :meatGrams"),
    @NamedQuery(name = "Meats.findByMeatCarbs", query = "SELECT m FROM Meats m WHERE m.meatCarbs = :meatCarbs")})
public class Meats extends Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEAT_ID")
    private Integer meatId;
    @Size(max = 50)
    @Column(name = "MEAT_TITLE")
    private String meatTitle;
    @Size(max = 50)
    @Column(name = "MEAT_MEASUREMENTS")
    private String meatMeasurements;
    @Column(name = "MEAT_GRAMS")
    private Integer meatGrams;
    @Column(name = "MEAT_CARBS")
    private Integer meatCarbs;

    public Meats() {
    }

    public Meats(Integer meatId) {
        this.meatId = meatId;
    }

    public Integer getMeatId() {
        return meatId;
    }

    public void setMeatId(Integer meatId) {
        this.meatId = meatId;
    }

    public String getMeatTitle() {
        return meatTitle;
    }

    public void setMeatTitle(String meatTitle) {
        this.meatTitle = meatTitle;
    }

    public String getMeatMeasurements() {
        return meatMeasurements;
    }

    public void setMeatMeasurements(String meatMeasurements) {
        this.meatMeasurements = meatMeasurements;
    }

    public Integer getMeatGrams() {
        return meatGrams;
    }

    public void setMeatGrams(Integer meatGrams) {
        this.meatGrams = meatGrams;
    }

    public Integer getMeatCarbs() {
        return meatCarbs;
    }

    public void setMeatCarbs(Integer meatCarbs) {
        this.meatCarbs = meatCarbs;
    }
     @Override
     public int getId() {
        return meatId;
    }

    @Override
    public String getTitle() {
        return meatTitle;
    }
    @Override
    public String getMesurments() {
        return meatMeasurements;
    }
    @Override
    public int getCarbs() {
        return meatCarbs;
    }
    @Override
    public int getGrams() {
        return meatGrams;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meatId != null ? meatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meats)) {
            return false;
        }
        Meats other = (Meats) object;
        if ((this.meatId == null && other.meatId != null) || (this.meatId != null && !this.meatId.equals(other.meatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Meats[ meatId=" + meatId + " ]";
    }
    
}
