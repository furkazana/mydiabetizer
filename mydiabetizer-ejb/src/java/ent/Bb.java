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
@Table(name = "BB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bb.findAll", query = "SELECT b FROM Bb b"),
    @NamedQuery(name = "Bb.findByBbUserDateId", query = "SELECT b FROM Bb b WHERE b.bbUserDateId = :bbUserDateId"),
    @NamedQuery(name = "Bb.findByBbSugar", query = "SELECT b FROM Bb b WHERE b.bbSugar = :bbSugar"),
    @NamedQuery(name = "Bb.findByBbInsulin", query = "SELECT b FROM Bb b WHERE b.bbInsulin = :bbInsulin"),
    @NamedQuery(name = "Bb.findByBbTime", query = "SELECT b FROM Bb b WHERE b.bbTime = :bbTime")})
public class Bb extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BB_USER_DATE_ID")
    private Integer bbUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BB_SUGAR")
    private Double bbSugar;
    @Column(name = "BB_INSULIN")
    private Integer bbInsulin;
    @Size(max = 32)
    @Column(name = "BB_TIME")
    private String bbTime;

    public Bb() {
    }

    public Bb(Integer bbUserDateId) {
        this.bbUserDateId = bbUserDateId;
    }

    public Integer getBbUserDateId() {
        return bbUserDateId;
    }

    public void setBbUserDateId(Integer bbUserDateId) {
        this.bbUserDateId = bbUserDateId;
    }

    public Double getBbSugar() {
        return bbSugar;
    }

    public void setBbSugar(Double bbSugar) {
        this.bbSugar = bbSugar;
    }

    public Integer getBbInsulin() {
        return bbInsulin;
    }

    public void setBbInsulin(Integer bbInsulin) {
        this.bbInsulin = bbInsulin;
    }

    public String getBbTime() {
        return bbTime;
    }

    public void setBbTime(String bbTime) {
        this.bbTime = bbTime;
    }
    
    @Override
     public Integer getUserDateId() {
        return bbUserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.bbUserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return bbSugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.bbSugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return bbInsulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.bbInsulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return bbTime;
    }
     @Override
    public void setTime(String oobTime) {
        this.bbTime = oobTime;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bbUserDateId != null ? bbUserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bb)) {
            return false;
        }
        Bb other = (Bb) object;
        if ((this.bbUserDateId == null && other.bbUserDateId != null) || (this.bbUserDateId != null && !this.bbUserDateId.equals(other.bbUserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Bb[ bbUserDateId=" + bbUserDateId + " ]";
    }
    
}
