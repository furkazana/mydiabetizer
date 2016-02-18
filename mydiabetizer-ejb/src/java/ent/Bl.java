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
@Table(name = "BL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bl.findAll", query = "SELECT b FROM Bl b"),
    @NamedQuery(name = "Bl.findByBlUserDateId", query = "SELECT b FROM Bl b WHERE b.blUserDateId = :blUserDateId"),
    @NamedQuery(name = "Bl.findByBlSugar", query = "SELECT b FROM Bl b WHERE b.blSugar = :blSugar"),
    @NamedQuery(name = "Bl.findByBlInsulin", query = "SELECT b FROM Bl b WHERE b.blInsulin = :blInsulin"),
    @NamedQuery(name = "Bl.findByBlTime", query = "SELECT b FROM Bl b WHERE b.blTime = :blTime")})
public class Bl extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BL_USER_DATE_ID")
    private Integer blUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BL_SUGAR")
    private Double blSugar;
    @Column(name = "BL_INSULIN")
    private Integer blInsulin;
    @Size(max = 32)
    @Column(name = "BL_TIME")
    private String blTime;

    public Bl() {
    }

    public Bl(Integer blUserDateId) {
        this.blUserDateId = blUserDateId;
    }

    public Integer getBlUserDateId() {
        return blUserDateId;
    }

    public void setBlUserDateId(Integer blUserDateId) {
        this.blUserDateId = blUserDateId;
    }

    public Double getBlSugar() {
        return blSugar;
    }

    public void setBlSugar(Double blSugar) {
        this.blSugar = blSugar;
    }

    public Integer getBlInsulin() {
        return blInsulin;
    }

    public void setBlInsulin(Integer blInsulin) {
        this.blInsulin = blInsulin;
    }

    public String getBlTime() {
        return blTime;
    }

    public void setBlTime(String blTime) {
        this.blTime = blTime;
    }
    
     @Override
     public Integer getUserDateId() {
        return blUserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.blUserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return blSugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.blSugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return blInsulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.blInsulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return blTime;
    }
     @Override
    public void setTime(String oobTime) {
        this.blTime = oobTime;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blUserDateId != null ? blUserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bl)) {
            return false;
        }
        Bl other = (Bl) object;
        if ((this.blUserDateId == null && other.blUserDateId != null) || (this.blUserDateId != null && !this.blUserDateId.equals(other.blUserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Bl[ blUserDateId=" + blUserDateId + " ]";
    }
    
}
