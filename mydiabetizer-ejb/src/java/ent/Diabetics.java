/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rock n Roll
 */
@Entity
@Table(name = "diabetics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diabetics.findAll", query = "SELECT d FROM Diabetics d"),
    @NamedQuery(name = "Diabetics.findByDiabeticId", query = "SELECT d FROM Diabetics d WHERE d.diabeticId = :diabeticId"),
    @NamedQuery(name = "Diabetics.findByFirsName", query = "SELECT d FROM Diabetics d WHERE d.firsName = :firsName"),
    @NamedQuery(name = "Diabetics.findBySurname", query = "SELECT d FROM Diabetics d WHERE d.surname = :surname"),
    @NamedQuery(name = "Diabetics.findByEmail", query = "SELECT d FROM Diabetics d WHERE d.email = :email"),
    @NamedQuery(name = "Diabetics.findByPassword", query = "SELECT d FROM Diabetics d WHERE d.password = :password"),
    @NamedQuery(name ="Diabetics.getHighestUserID", query = "SELECT MAX(b.diabeticId) FROM Diabetics b"),
    @NamedQuery(name = "Diabetics.findByEmailAndPassword", query = "SELECT d FROM Diabetics d WHERE d.password = :password and d.email = :email "),

    @NamedQuery(name = "Diabetics.findByRegisterDate", query = "SELECT d FROM Diabetics d WHERE d.registerDate = :registerDate")})
public class Diabetics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "diabetic_id")
    private Integer diabeticId;
    @Size(max = 32)
    @Column(name = "firs_name")
    private String firsName;
    @Size(max = 32)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 500)
    @Column(name = "password")
    private String password;
    @Column(name = "register_date")
    @Temporal(TemporalType.DATE)
    private Date registerDate;

    public Diabetics() {
    }

    public Diabetics(Integer diabeticId) {
        this.diabeticId = diabeticId;
    }

    public Integer getDiabeticId() {
        return diabeticId;
    }

    public void setDiabeticId(Integer diabeticId) {
        this.diabeticId = diabeticId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diabeticId != null ? diabeticId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diabetics)) {
            return false;
        }
        Diabetics other = (Diabetics) object;
        if ((this.diabeticId == null && other.diabeticId != null) || (this.diabeticId != null && !this.diabeticId.equals(other.diabeticId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Diabetics[ diabeticId=" + diabeticId + " ]";
    }
    
}
