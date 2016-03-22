/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

/**
 *
 * @author Rock n Roll
 */
public abstract class TimeSlots
{
 private   Double sugar;
 private   int  id;
 private   String time;
 private   int insulin;
 private   int randomId;
 
    public Double getSugar() {
        return sugar;
    }

    public Integer getInsulin() {
        return insulin;
    }

    public Integer getUserDateId() {
        return id;
    }

    public String getTime() {
        return time;
    }


    public void setInsulin(Integer insulin) {
        this.insulin = insulin;
    }

    public void setUserDateId(Integer id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSugar(Double sugar)
    {
        this.sugar=sugar;
    }
    
    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }
    
}
