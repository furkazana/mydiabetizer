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
@Table(name = "OOB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oob.findAll", query = "SELECT o FROM Oob o"),
    @NamedQuery(name = "Oob.findByOobUserDateId", query = "SELECT o FROM Oob o WHERE o.oobUserDateId = :oobUserDateId"),
    @NamedQuery(name = "Oob.findByOobSugar", query = "SELECT o FROM Oob o WHERE o.oobSugar = :oobSugar"),
    @NamedQuery(name = "Oob.findByOobInsulin", query = "SELECT o FROM Oob o WHERE o.oobInsulin = :oobInsulin"),
    @NamedQuery(name = "Oob.findByOobTime", query = "SELECT o FROM Oob o WHERE o.oobTime = :oobTime")})
public class Oob extends TimeSlots implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OOB_USER_DATE_ID")
    private Integer oobUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OOB_SUGAR")
    private Double oobSugar;
    @Column(name = "OOB_INSULIN")
    private Integer oobInsulin;
    @Size(max = 32)
    @Column(name = "OOB_TIME")
    private String oobTime;

    public Oob()
    {
    }
   
    public Oob(Integer oobUserDateId) {
        this.oobUserDateId = oobUserDateId;
    }

   
   

    public Integer getOobUserDateId() {
        return oobUserDateId;
    }
     @Override
     public Integer getUserDateId() {
        return oobUserDateId;
    }

    public void setOobUserDateId(Integer oobUserDateId) {
        this.oobUserDateId = oobUserDateId;
    }
     @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.oobUserDateId = oobUserDateId;
    }
    public Double getOobSugar() {
        return oobSugar;
    }
    @Override
     public Double getSugar() {
        return oobSugar;
    }

    public void setOobSugar(Double oobSugar) {
        this.oobSugar = oobSugar;
    }
    @Override
     public void setSugar(Double oobSugar) {
        this.oobSugar = oobSugar;
    }

    public Integer getOobInsulin() {
        return oobInsulin;
    }
    @Override
     public Integer getInsulin() {
        return oobInsulin;
    }
    
    public void setOobInsulin(Integer oobInsulin) {
        this.oobInsulin = oobInsulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.oobInsulin = oobInsulin;
    }

    public String getOobTime() {
        return oobTime;
    }
    @Override
     public String getTime() {
        return oobTime;
    }

    public void setOobTime(String oobTime) {
        this.oobTime = oobTime;
    }
    @Override
    public void setTime(String oobTime) {
        this.oobTime = oobTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oobUserDateId != null ? oobUserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oob)) {
            return false;
        }
        Oob other = (Oob) object;
        if ((this.oobUserDateId == null && other.oobUserDateId != null) || (this.oobUserDateId != null && !this.oobUserDateId.equals(other.oobUserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Oob[ oobUserDateId=" + oobUserDateId + " ]";
    }
    
}
