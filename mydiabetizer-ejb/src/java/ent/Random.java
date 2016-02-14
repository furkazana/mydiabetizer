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
@Table(name = "RANDOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Random.findAll", query = "SELECT r FROM Random r"),
    @NamedQuery(name = "Random.findByRandomId", query = "SELECT r FROM Random r WHERE r.randomId = :randomId"),
    @NamedQuery(name = "Random.findByRandomUserDateId", query = "SELECT r FROM Random r WHERE r.randomUserDateId = :randomUserDateId"),
    @NamedQuery(name = "Random.findByRandomSugar", query = "SELECT r FROM Random r WHERE r.randomSugar = :randomSugar"),
    @NamedQuery(name = "Random.findByRandomInsulin", query = "SELECT r FROM Random r WHERE r.randomInsulin = :randomInsulin"),
    @NamedQuery(name = "Random.findByRandomTime", query = "SELECT r FROM Random r WHERE r.randomTime = :randomTime")})
public class Random implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANDOM_ID")
    private Integer randomId;
    @Column(name = "RANDOM_USER_DATE_ID")
    private Integer randomUserDateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RANDOM_SUGAR")
    private Double randomSugar;
    @Column(name = "RANDOM_INSULIN")
    private Integer randomInsulin;
    @Size(max = 32)
    @Column(name = "RANDOM_TIME")
    private String randomTime;

    public Random() {
    }

    public Random(Integer randomId) {
        this.randomId = randomId;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

    public Integer getRandomUserDateId() {
        return randomUserDateId;
    }

    public void setRandomUserDateId(Integer randomUserDateId) {
        this.randomUserDateId = randomUserDateId;
    }

    public Double getRandomSugar() {
        return randomSugar;
    }

    public void setRandomSugar(Double randomSugar) {
        this.randomSugar = randomSugar;
    }

    public Integer getRandomInsulin() {
        return randomInsulin;
    }

    public void setRandomInsulin(Integer randomInsulin) {
        this.randomInsulin = randomInsulin;
    }

    public String getRandomTime() {
        return randomTime;
    }

    public void setRandomTime(String randomTime) {
        this.randomTime = randomTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (randomId != null ? randomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Random)) {
            return false;
        }
        Random other = (Random) object;
        if ((this.randomId == null && other.randomId != null) || (this.randomId != null && !this.randomId.equals(other.randomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Random[ randomId=" + randomId + " ]";
    }
    
}
