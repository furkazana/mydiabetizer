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
@Table(name = "VEGETABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vegetables.findAll", query = "SELECT v FROM Vegetables v"),
    @NamedQuery(name = "Vegetables.findByVegId", query = "SELECT v FROM Vegetables v WHERE v.vegId = :vegId"),
    @NamedQuery(name = "Vegetables.findByVegTitle", query = "SELECT v FROM Vegetables v WHERE v.vegTitle = :vegTitle"),
    @NamedQuery(name = "Vegetables.getHighestVegID", query = "SELECT MAX(v.vegId) FROM Vegetables v"),
    @NamedQuery(name = "Vegetables.findByVegGrams", query = "SELECT v FROM Vegetables v WHERE v.vegGrams = :vegGrams"),
    @NamedQuery(name = "Vegetables.findByVegCarbs", query = "SELECT v FROM Vegetables v WHERE v.vegCarbs = :vegCarbs"),
    @NamedQuery(name = "Vegetables.findByVegMeasurements", query = "SELECT v FROM Vegetables v WHERE v.vegMeasurements = :vegMeasurements")})
public class Vegetables extends Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEG_ID")
    private Integer vegId;
    @Size(max = 32)
    @Column(name = "VEG_TITLE")
    private String vegTitle;
    @Column(name = "VEG_GRAMS")
    private Integer vegGrams;
    @Column(name = "VEG_CARBS")
    private Integer vegCarbs;
    @Size(max = 50)
    @Column(name = "VEG_MEASUREMENTS")
    private String vegMeasurements;

    public Vegetables() {
    }

    public Vegetables(Integer vegId) {
        this.vegId = vegId;
    }

    public Integer getVegId() {
        return vegId;
    }

    public void setVegId(Integer vegId) {
        this.vegId = vegId;
    }

    public String getVegTitle() {
        return vegTitle;
    }

    public void setVegTitle(String vegTitle) {
        this.vegTitle = vegTitle;
    }

    public Integer getVegGrams() {
        return vegGrams;
    }

    public void setVegGrams(Integer vegGrams) {
        this.vegGrams = vegGrams;
    }

    public Integer getVegCarbs() {
        return vegCarbs;
    }

    public void setVegCarbs(Integer vegCarbs) {
        this.vegCarbs = vegCarbs;
    }

    public String getVegMeasurements() {
        return vegMeasurements;
    }

    public void setVegMeasurements(String vegMeasurements) {
        this.vegMeasurements = vegMeasurements;
    }
    @Override
     public int getId() {
        return vegId;
    }

    @Override
    public String getTitle() {
        return vegTitle;
    }
    @Override
    public String getMesurments() {
        return vegMeasurements;
    }
    @Override
    public int getCarbs() {
        return vegCarbs;
    }
    @Override
    public int getGrams() {
        return vegGrams;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vegId != null ? vegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vegetables)) {
            return false;
        }
        Vegetables other = (Vegetables) object;
        if ((this.vegId == null && other.vegId != null) || (this.vegId != null && !this.vegId.equals(other.vegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Vegetables[ vegId=" + vegId + " ]";
    }
    
}
