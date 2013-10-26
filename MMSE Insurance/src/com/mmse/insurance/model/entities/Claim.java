/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model.entities;

/**
 *
 * @author Adam
 */
public class Claim {
    private int id;
    private Customer customer;
    private boolean severe;
    private double carPrice;
    private double damagePrice;
    private ClaimState state;  

    public Claim(int id, Customer customer, boolean severe, double carPrice, double damagePrice, ClaimState state) {
        this.id = id;
        this.customer = customer;
        this.severe = severe;
        this.carPrice = carPrice;
        this.damagePrice = damagePrice;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
    
            
    
}
