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
@Table(name = "USERRATIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userratios.findAll", query = "SELECT u FROM Userratios u"),
    @NamedQuery(name = "Userratios.findByRatioId", query = "SELECT u FROM Userratios u WHERE u.ratioId = :ratioId"),
    @NamedQuery(name = "Userratios.getHighestID", query = "SELECT MAX(u.ratioId) FROM Userratios u"),
    @NamedQuery(name = "Userratios.findByUserId", query = "SELECT u FROM Userratios u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userratios.findByBreakfast", query = "SELECT u FROM Userratios u WHERE u.breakfast = :breakfast"),
    @NamedQuery(name = "Userratios.findByLunch", query = "SELECT u FROM Userratios u WHERE u.lunch = :lunch"),
    @NamedQuery(name = "Userratios.findByDiner", query = "SELECT u FROM Userratios u WHERE u.diner = :diner"),
    @NamedQuery(name = "Userratios.findByGeneral", query = "SELECT u FROM Userratios u WHERE u.general = :general"),
    @NamedQuery(name = "Userratios.findByDate", query = "SELECT u FROM Userratios u WHERE u.date = :date")})
public class Userratios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATIO_ID")
    private Integer ratioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BREAKFAST")
    private double breakfast;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LUNCH")
    private double lunch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DINER")
    private double diner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENERAL")
    private double general;
    @Size(max = 30)
    @Column(name = "DATE")
    private String date;

    public Userratios() {
    }

    public Userratios(Integer ratioId) {
        this.ratioId = ratioId;
    }

    public Userratios(Integer ratioId, int userId, double breakfast, double lunch, double diner, double general) {
        this.ratioId = ratioId;
        this.userId = userId;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.diner = diner;
        this.general = general;
    }

    public Integer getRatioId() {
        return ratioId;
    }

    public void setRatioId(Integer ratioId) {
        this.ratioId = ratioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(double breakfast) {
        this.breakfast = breakfast;
    }

    public double getLunch() {
        return lunch;
    }

    public void setLunch(double lunch) {
        this.lunch = lunch;
    }

    public double getDiner() {
        return diner;
    }

    public void setDiner(double diner) {
        this.diner = diner;
    }

    public double getGeneral() {
        return general;
    }

    public void setGeneral(double general) {
        this.general = general;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratioId != null ? ratioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userratios)) {
            return false;
        }
        Userratios other = (Userratios) object;
        if ((this.ratioId == null && other.ratioId != null) || (this.ratioId != null && !this.ratioId.equals(other.ratioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Userratios[ ratioId=" + ratioId + " ]";
    }
    
}
