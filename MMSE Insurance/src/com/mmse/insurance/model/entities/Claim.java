/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model.entities;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Adam
 */
public class Claim {
    private Customer customer;
    private boolean severe;
    private double carPrice;
    private double damagePrice;
    private ClaimState state;  
    private Date date;

    public Claim(Customer customer, double carPrice, double damagePrice, ClaimState state) {
        
        this.customer = customer;
        this.severe = false;
        this.carPrice = carPrice;
        this.damagePrice = damagePrice;
        this.state = state;
        this.date = new Date();
    }   
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isSevere() {
        return severe;
    }

    public void setSevere(boolean severe) {
        this.severe = severe;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public double getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(double damagePrice) {
        this.damagePrice = damagePrice;
    }

    public ClaimState getState() {
        return state;
    }

    public void setState(ClaimState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Claim{" + "customer=" + customer + ", severe=" + severe + ", carPrice=" + carPrice + ", damagePrice=" + damagePrice + ", state=" + state + ", date=" + date + '}';
    }

    
    
    
            
    
}
