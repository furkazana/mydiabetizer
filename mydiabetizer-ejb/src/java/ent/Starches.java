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
@Table(name = "STARCHES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Starches.findAll", query = "SELECT s FROM Starches s"),
    @NamedQuery(name = "Starches.findByStarchId", query = "SELECT s FROM Starches s WHERE s.starchId = :starchId"),
    @NamedQuery(name = "Starches.findByStarchTitle", query = "SELECT s FROM Starches s WHERE s.starchTitle = :starchTitle"),
    @NamedQuery(name = "Starches.getHighestStarID", query = "SELECT MAX(s.starchId) FROM Starches s"),
    @NamedQuery(name = "Starches.findByStarchMeasurements", query = "SELECT s FROM Starches s WHERE s.starchMeasurements = :starchMeasurements"),
    @NamedQuery(name = "Starches.findByStarchGrams", query = "SELECT s FROM Starches s WHERE s.starchGrams = :starchGrams"),
    @NamedQuery(name = "Starches.findByStarchCarbs", query = "SELECT s FROM Starches s WHERE s.starchCarbs = :starchCarbs")})
public class Starches extends Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARCH_ID")
    private Integer starchId;
    @Size(max = 50)
    @Column(name = "STARCH_TITLE")
    private String starchTitle;
    @Size(max = 50)
    @Column(name = "STARCH_MEASUREMENTS")
    private String starchMeasurements;
    @Column(name = "STARCH_GRAMS")
    private Integer starchGrams;
    @Column(name = "STARCH_CARBS")
    private Integer starchCarbs;

    public Starches() {
    }

    public Starches(Integer starchId) {
        this.starchId = starchId;
    }

    public Integer getStarchId() {
        return starchId;
    }

    public void setStarchId(Integer starchId) {
        this.starchId = starchId;
    }

    public String getStarchTitle() {
        return starchTitle;
    }

    public void setStarchTitle(String starchTitle) {
        this.starchTitle = starchTitle;
    }

    public String getStarchMeasurements() {
        return starchMeasurements;
    }

    public void setStarchMeasurements(String starchMeasurements) {
        this.starchMeasurements = starchMeasurements;
    }

    public Integer getStarchGrams() {
        return starchGrams;
    }

    public void setStarchGrams(Integer starchGrams) {
        this.starchGrams = starchGrams;
    }

    public Integer getStarchCarbs() {
        return starchCarbs;
    }

    public void setStarchCarbs(Integer starchCarbs) {
        this.starchCarbs = starchCarbs;
    }
     @Override
     public int getId() {
        return starchId;
    }

    @Override
    public String getTitle() {
        return starchTitle;
    }
    @Override
    public String getMesurments() {
        return starchMeasurements;
    }
    @Override
    public int getCarbs() {
        return starchCarbs;
    }
    @Override
    public int getGrams() {
        return starchGrams;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (starchId != null ? starchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Starches)) {
            return false;
        }
        Starches other = (Starches) object;
        if ((this.starchId == null && other.starchId != null) || (this.starchId != null && !this.starchId.equals(other.starchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Starches[ starchId=" + starchId + " ]";
    }
    
}
