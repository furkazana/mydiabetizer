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
@Table(name = "DIABETICS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diabetics.findAll", query = "SELECT d FROM Diabetics d"),
    @NamedQuery(name = "Diabetics.findById", query = "SELECT d FROM Diabetics d WHERE d.id = :id"),
    @NamedQuery(name = "Diabetics.findByEmail", query = "SELECT d FROM Diabetics d WHERE d.email = :email"),
    @NamedQuery(name = "Diabetics.findByPassword", query = "SELECT d FROM Diabetics d WHERE d.password = :password"),
    @NamedQuery(name = "Diabetics.findByDate", query = "SELECT d FROM Diabetics d WHERE d.date = :date"),
    @NamedQuery(name = "Diabetics.findByFirstname", query = "SELECT d FROM Diabetics d WHERE d.firstname = :firstname"),
     @NamedQuery(name ="Diabetics.getHighestUserID", query = "SELECT MAX(b.id) FROM Diabetics b"),
    @NamedQuery(name = "Diabetics.findByEmailAndPassword", query = "SELECT d FROM Diabetics d WHERE d.password = :password and d.email = :email "),
    @NamedQuery(name = "Diabetics.findBySurname", query = "SELECT d FROM Diabetics d WHERE d.surname = :surname")})
public class Diabetics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 200)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 100)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 200)
    @Column(name = "SURNAME")
    private String surname;

    public Diabetics() {
    }

    public Diabetics(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diabetics)) {
            return false;
        }
        Diabetics other = (Diabetics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Diabetics[ id=" + id + " ]";
    }
    
}
