/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model.entities;

import java.util.Objects;

/**
 *
 * @author Adam
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private int personalId;

    public Customer(String firstName, String lastName, int personalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
    }

    public Customer(String firstName, String lastName) {
        
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + this.personalId;
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.personalId != other.personalId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", personalId=" + personalId + '}';
    }
    
    
    
    
    
    
    
    
}
