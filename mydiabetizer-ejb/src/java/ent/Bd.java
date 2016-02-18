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
@Table(name = "BD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bd.findAll", query = "SELECT b FROM Bd b"),
    @NamedQuery(name = "Bd.findByBdUserDateId", query = "SELECT b FROM Bd b WHERE b.bdUserDateId = :bdUserDateId"),
    @NamedQuery(name = "Bd.findByBdSugar", query = "SELECT b FROM Bd b WHERE b.bdSugar = :bdSugar"),
    @NamedQuery(name = "Bd.findByBdInsulin", query = "SELECT b FROM Bd b WHERE b.bdInsulin = :bdInsulin"),
    @NamedQuery(name = "Bd.findByBdTime", query = "SELECT b FROM Bd b WHERE b.bdTime = :bdTime")})
public class Bd extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BD_USER_DATE_ID")
    private Integer bdUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BD_SUGAR")
    private Double bdSugar;
    @Column(name = "BD_INSULIN")
    private Integer bdInsulin;
    @Size(max = 32)
    @Column(name = "BD_TIME")
    private String bdTime;

    public Bd() {
    }

    public Bd(Integer bdUserDateId) {
        this.bdUserDateId = bdUserDateId;
    }

    public Integer getBdUserDateId() {
        return bdUserDateId;
    }

    public void setBdUserDateId(Integer bdUserDateId) {
        this.bdUserDateId = bdUserDateId;
    }

    public Double getBdSugar() {
        return bdSugar;
    }

    public void setBdSugar(Double bdSugar) {
        this.bdSugar = bdSugar;
    }

    public Integer getBdInsulin() {
        return bdInsulin;
    }

    public void setBdInsulin(Integer bdInsulin) {
        this.bdInsulin = bdInsulin;
    }

    public String getBdTime() {
        return bdTime;
    }

    public void setBdTime(String bdTime) {
        this.bdTime = bdTime;
    }
   
     @Override
     public Integer getUserDateId() {
        return bdUserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.bdUserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return bdSugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.bdSugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return bdInsulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.bdInsulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return bdTime;
    }
     @Override
    public void setTime(String oobTime) {
        this.bdTime = oobTime;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdUserDateId != null ? bdUserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bd)) {
            return false;
        }
        Bd other = (Bd) object;
        if ((this.bdUserDateId == null && other.bdUserDateId != null) || (this.bdUserDateId != null && !this.bdUserDateId.equals(other.bdUserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Bd[ bdUserDateId=" + bdUserDateId + " ]";
    }
    
}
