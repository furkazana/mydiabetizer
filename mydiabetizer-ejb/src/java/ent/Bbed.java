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
@Table(name = "BBED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bbed.findAll", query = "SELECT b FROM Bbed b"),
    @NamedQuery(name = "Bbed.findByBbedUserDateId", query = "SELECT b FROM Bbed b WHERE b.bbedUserDateId = :bbedUserDateId"),
    @NamedQuery(name = "Bbed.findByBbedSugar", query = "SELECT b FROM Bbed b WHERE b.bbedSugar = :bbedSugar"),
    @NamedQuery(name = "Bbed.findByBbedInsulin", query = "SELECT b FROM Bbed b WHERE b.bbedInsulin = :bbedInsulin"),
    @NamedQuery(name = "Bbed.findByBbedTime", query = "SELECT b FROM Bbed b WHERE b.bbedTime = :bbedTime")})
public class Bbed extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BBED_USER_DATE_ID")
    private Integer bbedUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BBED_SUGAR")
    private Double bbedSugar;
    @Column(name = "BBED_INSULIN")
    private Integer bbedInsulin;
    @Size(max = 32)
    @Column(name = "BBED_TIME")
    private String bbedTime;

    public Bbed() {
    }

    public Bbed(Integer bbedUserDateId) {
        this.bbedUserDateId = bbedUserDateId;
    }

    public Integer getBbedUserDateId() {
        return bbedUserDateId;
    }

    public void setBbedUserDateId(Integer bbedUserDateId) {
        this.bbedUserDateId = bbedUserDateId;
    }

    public Double getBbedSugar() {
        return bbedSugar;
    }

    public void setBbedSugar(Double bbedSugar) {
        this.bbedSugar = bbedSugar;
    }

    public Integer getBbedInsulin() {
        return bbedInsulin;
    }

    public void setBbedInsulin(Integer bbedInsulin) {
        this.bbedInsulin = bbedInsulin;
    }

    public String getBbedTime() {
        return bbedTime;
    }

    public void setBbedTime(String bbedTime) {
        this.bbedTime = bbedTime;
    }
    
     @Override
     public Integer getUserDateId() {
        return bbedUserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.bbedUserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return bbedSugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.bbedSugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return bbedInsulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.bbedInsulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return bbedTime;
    }
     @Override
    public void setTime(String oobTime) {
        this.bbedTime = oobTime;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bbedUserDateId != null ? bbedUserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bbed)) {
            return false;
        }
        Bbed other = (Bbed) object;
        if ((this.bbedUserDateId == null && other.bbedUserDateId != null) || (this.bbedUserDateId != null && !this.bbedUserDateId.equals(other.bbedUserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Bbed[ bbedUserDateId=" + bbedUserDateId + " ]";
    }
    
}
