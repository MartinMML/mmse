package com.mmse.insurance.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Entity class defined with getters and setters only
 * @author Adam
 */
public class Claim implements Serializable {
	
    /** Default serial version ID */
	private static final long serialVersionUID = 1L;
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Claim other = (Claim) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (this.severe != other.severe) {
            return false;
        }
        if (Double.doubleToLongBits(this.carPrice) != Double.doubleToLongBits(other.carPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.damagePrice) != Double.doubleToLongBits(other.damagePrice)) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        return true;
    }
    
    

    
    
    
            
    
}
