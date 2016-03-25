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
@Table(name = "DIARYDATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diarydates.findAll", query = "SELECT d FROM Diarydates d"),
    @NamedQuery(name = "Diarydates.findByDiarydateId", query = "SELECT d FROM Diarydates d WHERE d.diarydateId = :diarydateId"),
    @NamedQuery(name = "Diarydates.findByUserId", query = "SELECT d FROM Diarydates d WHERE d.userId = :userId"),
    @NamedQuery(name = "Diarydates.findByDate", query = "SELECT d FROM Diarydates d WHERE d.date = :date"),
    @NamedQuery(name = "Diarydates.findHighestTableNumber", query = "SELECT max(d.diarydateId) FROM Diarydates d"),
    @NamedQuery(name = "Diarydates.findByUserIdAndDate", query = "SELECT d FROM Diarydates d WHERE d.userId = :userId and d.date = :date " ),
    @NamedQuery(name = "Diarydates.findByIll", query = "SELECT d FROM Diarydates d WHERE d.ill = :ill")})
public class Diarydates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIARYDATE_ID")
    private Integer diarydateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "DATE")
    private String date;
    @Size(max = 10)
    @Column(name = "ILL")
    private String ill;

    public Diarydates() {
    }

    public Diarydates(Integer diarydateId) {
        this.diarydateId = diarydateId;
    }

    public Diarydates(Integer diarydateId, int userId, String date) {
        this.diarydateId = diarydateId;
        this.userId = userId;
        this.date = date;
    }

    public Integer getDiarydateId() {
        return diarydateId;
    }

    public void setDiarydateId(Integer diarydateId) {
        this.diarydateId = diarydateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diarydateId != null ? diarydateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diarydates)) {
            return false;
        }
        Diarydates other = (Diarydates) object;
        if ((this.diarydateId == null && other.diarydateId != null) || (this.diarydateId != null && !this.diarydateId.equals(other.diarydateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Diarydates[ diarydateId=" + diarydateId + " ]";
    }
    
}