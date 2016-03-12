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
@Table(name = "FATSANDSWEETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatsandsweets.findAll", query = "SELECT f FROM Fatsandsweets f"),
    @NamedQuery(name = "Fatsandsweets.findByFnsId", query = "SELECT f FROM Fatsandsweets f WHERE f.fnsId = :fnsId"),
    @NamedQuery(name = "Fatsandsweets.getHighestFnsID", query = "SELECT MAX(f.fnsId) FROM Fatsandsweets f"),
    @NamedQuery(name = "Fatsandsweets.findByFnsTitle", query = "SELECT f FROM Fatsandsweets f WHERE f.fnsTitle = :fnsTitle"),
    @NamedQuery(name = "Fatsandsweets.findByFnsMeasurements", query = "SELECT f FROM Fatsandsweets f WHERE f.fnsMeasurements = :fnsMeasurements"),
    @NamedQuery(name = "Fatsandsweets.findByFnsGrams", query = "SELECT f FROM Fatsandsweets f WHERE f.fnsGrams = :fnsGrams"),
    @NamedQuery(name = "Fatsandsweets.findByFnsCarbs", query = "SELECT f FROM Fatsandsweets f WHERE f.fnsCarbs = :fnsCarbs")})
public class Fatsandsweets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FNS_ID")
    private Integer fnsId;
    @Size(max = 50)
    @Column(name = "FNS_TITLE")
    private String fnsTitle;
    @Size(max = 50)
    @Column(name = "FNS_MEASUREMENTS")
    private String fnsMeasurements;
    @Column(name = "FNS_GRAMS")
    private Integer fnsGrams;
    @Column(name = "FNS_CARBS")
    private Integer fnsCarbs;

    public Fatsandsweets() {
    }

    public Fatsandsweets(Integer fnsId) {
        this.fnsId = fnsId;
    }

    public Integer getFnsId() {
        return fnsId;
    }

    public void setFnsId(Integer fnsId) {
        this.fnsId = fnsId;
    }

    public String getFnsTitle() {
        return fnsTitle;
    }

    public void setFnsTitle(String fnsTitle) {
        this.fnsTitle = fnsTitle;
    }

    public String getFnsMeasurements() {
        return fnsMeasurements;
    }

    public void setFnsMeasurements(String fnsMeasurements) {
        this.fnsMeasurements = fnsMeasurements;
    }

    public Integer getFnsGrams() {
        return fnsGrams;
    }

    public void setFnsGrams(Integer fnsGrams) {
        this.fnsGrams = fnsGrams;
    }

    public Integer getFnsCarbs() {
        return fnsCarbs;
    }

    public void setFnsCarbs(Integer fnsCarbs) {
        this.fnsCarbs = fnsCarbs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fnsId != null ? fnsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatsandsweets)) {
            return false;
        }
        Fatsandsweets other = (Fatsandsweets) object;
        if ((this.fnsId == null && other.fnsId != null) || (this.fnsId != null && !this.fnsId.equals(other.fnsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Fatsandsweets[ fnsId=" + fnsId + " ]";
    }
    
}
