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
@Table(name = "DPLUS2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dplus2.findAll", query = "SELECT d FROM Dplus2 d"),
    @NamedQuery(name = "Dplus2.findByD2UserDateId", query = "SELECT d FROM Dplus2 d WHERE d.d2UserDateId = :d2UserDateId"),
    @NamedQuery(name = "Dplus2.findByD2Sugar", query = "SELECT d FROM Dplus2 d WHERE d.d2Sugar = :d2Sugar"),
    @NamedQuery(name = "Dplus2.findByD2Insulin", query = "SELECT d FROM Dplus2 d WHERE d.d2Insulin = :d2Insulin"),
    @NamedQuery(name = "Dplus2.findByD2Time", query = "SELECT d FROM Dplus2 d WHERE d.d2Time = :d2Time")})
public class Dplus2 extends TimeSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "D2_USER_DATE_ID")
    private Integer d2UserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "D2_SUGAR")
    private Double d2Sugar;
    @Column(name = "D2_INSULIN")
    private Integer d2Insulin;
    @Size(max = 32)
    @Column(name = "D2_TIME")
    private String d2Time;

    public Dplus2() {
    }

    public Dplus2(Integer d2UserDateId) {
        this.d2UserDateId = d2UserDateId;
    }

    public Integer getD2UserDateId() {
        return d2UserDateId;
    }

    public void setD2UserDateId(Integer d2UserDateId) {
        this.d2UserDateId = d2UserDateId;
    }

    public Double getD2Sugar() {
        return d2Sugar;
    }

    public void setD2Sugar(Double d2Sugar) {
        this.d2Sugar = d2Sugar;
    }

    public Integer getD2Insulin() {
        return d2Insulin;
    }

    public void setD2Insulin(Integer d2Insulin) {
        this.d2Insulin = d2Insulin;
    }

    public String getD2Time() {
        return d2Time;
    }

    public void setD2Time(String d2Time) {
        this.d2Time = d2Time;
    }
    @Override
     public Integer getUserDateId() {
        return d2UserDateId;
    }
      @Override
     public void setUserDateId(Integer oobUserDateId) {
        this.d2UserDateId = oobUserDateId;
    }
      @Override
     public Double getSugar() {
        return d2Sugar;
    }
     @Override
     public void setSugar(Double oobSugar) {
        this.d2Sugar = oobSugar;
    }
     @Override
     public Integer getInsulin() {
        return d2Insulin;
    }
     @Override
     public void setInsulin(Integer oobInsulin) {
        this.d2Insulin = oobInsulin;
    }
     @Override
     public String getTime() {
        return d2Time;
    }
     @Override
    public void setTime(String oobTime) {
        this.d2Time = oobTime;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (d2UserDateId != null ? d2UserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dplus2)) {
            return false;
        }
        Dplus2 other = (Dplus2) object;
        if ((this.d2UserDateId == null && other.d2UserDateId != null) || (this.d2UserDateId != null && !this.d2UserDateId.equals(other.d2UserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Dplus2[ d2UserDateId=" + d2UserDateId + " ]";
    }
    
}
