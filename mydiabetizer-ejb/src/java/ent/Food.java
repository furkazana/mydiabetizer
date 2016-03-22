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
public abstract class Food
{
    private int id;
    private String title;
    private String mesurments;
    private int carbs;
    private int grams;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMesurments() {
        return mesurments;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getGrams() {
        return grams;
    }
   
    
}
