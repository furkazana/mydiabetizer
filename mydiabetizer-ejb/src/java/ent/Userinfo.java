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
@Table(name = "USERINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u"),
    @NamedQuery(name = "Userinfo.findByUserInfoId", query = "SELECT u FROM Userinfo u WHERE u.userInfoId = :userInfoId"),
    @NamedQuery(name = "Userinfo.findByUserId", query = "SELECT u FROM Userinfo u WHERE u.userId = :userId"),
    @NamedQuery(name = "Userinfo.getHighestID", query = "SELECT MAX(u.userInfoId) FROM Userinfo u"),
    @NamedQuery(name = "Userinfo.findByKg", query = "SELECT u FROM Userinfo u WHERE u.kg = :kg"),
    @NamedQuery(name = "Userinfo.findByBodyType", query = "SELECT u FROM Userinfo u WHERE u.bodyType = :bodyType"),
    @NamedQuery(name = "Userinfo.updateUserInfo", query = "UPDATE Userinfo SET kg = :kg, bodyType = :bodyType, "
            + " totalInsulinD = :totalInsulinD WHERE userId = :userId"),
    @NamedQuery(name = "Userinfo.findByTotalInsulinD", query = "SELECT u FROM Userinfo u WHERE u.totalInsulinD = :totalInsulinD")})
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_INFO_ID")
    private Integer userInfoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KG")
    private double kg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BODY_TYPE")
    private String bodyType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_INSULIN_D")
    private int totalInsulinD;

    public Userinfo() {
    }

    public Userinfo(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Userinfo(Integer userInfoId, int userId, double kg, String bodyType, int totalInsulinD) {
        this.userInfoId = userInfoId;
        this.userId = userId;
        this.kg = kg;
        this.bodyType = bodyType;
        this.totalInsulinD = totalInsulinD;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getTotalInsulinD() {
        return totalInsulinD;
    }

    public void setTotalInsulinD(int totalInsulinD) {
        this.totalInsulinD = totalInsulinD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userInfoId != null ? userInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.userInfoId == null && other.userInfoId != null) || (this.userInfoId != null && !this.userInfoId.equals(other.userInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Userinfo[ userInfoId=" + userInfoId + " ]";
    }
    
}
