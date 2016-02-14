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
@Table(name = "LPLUS2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lplus2.findAll", query = "SELECT l FROM Lplus2 l"),
    @NamedQuery(name = "Lplus2.findByL2UserDateId", query = "SELECT l FROM Lplus2 l WHERE l.l2UserDateId = :l2UserDateId"),
    @NamedQuery(name = "Lplus2.findByL2Sugar", query = "SELECT l FROM Lplus2 l WHERE l.l2Sugar = :l2Sugar"),
    @NamedQuery(name = "Lplus2.findByL2Insulin", query = "SELECT l FROM Lplus2 l WHERE l.l2Insulin = :l2Insulin"),
    @NamedQuery(name = "Lplus2.findByL2Time", query = "SELECT l FROM Lplus2 l WHERE l.l2Time = :l2Time")})
public class Lplus2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "L2_USER_DATE_ID")
    private Integer l2UserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "L2_SUGAR")
    private Double l2Sugar;
    @Column(name = "L2_INSULIN")
    private Integer l2Insulin;
    @Size(max = 32)
    @Column(name = "L2_TIME")
    private String l2Time;

    public Lplus2() {
    }

    public Lplus2(Integer l2UserDateId) {
        this.l2UserDateId = l2UserDateId;
    }

    public Integer getL2UserDateId() {
        return l2UserDateId;
    }

    public void setL2UserDateId(Integer l2UserDateId) {
        this.l2UserDateId = l2UserDateId;
    }

    public Double getL2Sugar() {
        return l2Sugar;
    }

    public void setL2Sugar(Double l2Sugar) {
        this.l2Sugar = l2Sugar;
    }

    public Integer getL2Insulin() {
        return l2Insulin;
    }

    public void setL2Insulin(Integer l2Insulin) {
        this.l2Insulin = l2Insulin;
    }

    public String getL2Time() {
        return l2Time;
    }

    public void setL2Time(String l2Time) {
        this.l2Time = l2Time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (l2UserDateId != null ? l2UserDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lplus2)) {
            return false;
        }
        Lplus2 other = (Lplus2) object;
        if ((this.l2UserDateId == null && other.l2UserDateId != null) || (this.l2UserDateId != null && !this.l2UserDateId.equals(other.l2UserDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Lplus2[ l2UserDateId=" + l2UserDateId + " ]";
    }
    
}
