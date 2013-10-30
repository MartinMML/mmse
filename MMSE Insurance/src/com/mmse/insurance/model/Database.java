package com.mmse.insurance.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.Customer;
import com.mmse.insurance.model.entities.User;

/**
 *
 * @author Adam
 */
public class Database implements Serializable {
    
    /** Default serial version ID */
	private static final long serialVersionUID = 1L;
	private Set<Claim> claims = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private Set<Customer>customers = new HashSet<>();
    
    public Set<Claim> getAllClaims(){
        
        return claims;
    }
    
    public Set<Claim> getClaimsByCustomer(Customer c){
        Set<Claim> resultSet = new HashSet<>();
        for (Claim claim : claims) {
            if(claim.getCustomer().equals(c)) resultSet.add(claim);
        }
        return resultSet;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
    
    public boolean isInsured(Customer customer){
        return customers.contains(customer);
    }
    
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public void deleteCustomer(Customer customer){
        customers.remove(customer);
    }
    
    public void addClaim(Claim claim){
        claims.add(claim);
    }

    public void deleteClaim(Claim claim) {
        claims.remove(claim);
    }
    
    
    
}
