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
@Table(name = "BPLUS2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bplus2.findAll", query = "SELECT b FROM Bplus2 b"),
    @NamedQuery(name = "Bplus2.findByB2UserDateId", query = "SELECT b FROM Bplus2 b WHERE b.b2UserDateId = :b2UserDateId"),
    @NamedQuery(name = "Bplus2.findByB2Sugar", query = "SELECT b FROM Bplus2 b WHERE b.b2Sugar = :b2Sugar"),
    @NamedQuery(name = "Bplus2.findByB2Insulin", query = "SELECT b FROM Bplus2 b WHERE b.b2Insulin = :b2Insulin"),
    @NamedQuery(name = "Bplus2.findByB2Time", query = "SELECT b FROM Bplus2 b WHERE b.b2Time = :b2Time")})
public class Bplus2 extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "B2_USER_DATE_ID")
    private Integer b2UserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "B2_SUGAR")
    private Double b2Sugar;
    @Column(name = "B2_INSULIN")
    private Integer b2Insulin;
    @Size(max = 32)
    @Column(name = "B2_TIME")
    private String b2Time;

    public Bplus2() {
    }

    public Bplus2(Integer b2UserDateId) {
        this.b2UserDateId = b2UserDateId;
    }

    public Integer getB2UserDateId() {
        return b2UserDateId;
    }

    public void setB2UserDateId(Integer b2UserDateId) {
        this.b2UserDateId = b2UserDateId;
    }

    public Double getB2Sugar() {
        return b2Sugar;
    }

    public void setB2Sugar(Double b2Sugar) {
        this.b2Sugar = b2Sugar;
    }

    public Integer getB2Insulin() {
        return b2Insulin;
    }

    public void setB2Insulin(Integer b2Insulin) {
        this.b2Insulin = b2Insulin;
    }

    public String getB2Time() {
        return b2Time;
    }

    public void setB2Time(String b2Time) {
        this.b2Time = b2Time;
    }
    @Override
     public Integer getUserDateId() {
        return b2UserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.b2UserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return b2Sugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.b2Sugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return b2Insulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.b2Insulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return b2Time;
    }
     @Override
    public void setTime(String oobTime) {
        this.b2Time = oobTime;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (b2UserDateId != null ? b2UserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bplus2)) {
            return false;
        }
        Bplus2 other = (Bplus2) object;
        if ((this.b2UserDateId == null && other.b2UserDateId != null) || (this.b2UserDateId != null && !this.b2UserDateId.equals(other.b2UserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Bplus2[ b2UserDateId=" + b2UserDateId + " ]";
    }
    
}
