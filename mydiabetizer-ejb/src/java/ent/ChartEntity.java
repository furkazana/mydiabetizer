/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
@Entity
public class ChartEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private double sugar;
    private int insulin; 
    private String time;
    private String date;

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof ChartEntity)) {
            return false;
        }
        ChartEntity other = (ChartEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChartEntity{" + "sugar=" + sugar + ", insulin=" + insulin + ", time=" + time + ", date=" + date + ", id=" + id + '}';
    }

    
    
}
