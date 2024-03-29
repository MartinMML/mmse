/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.Customer;
import com.mmse.insurance.model.entities.User;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Adam
 */
public interface IDatabase {

    void addClaim(Claim claim);

    void addCustomer(Customer customer);

    void deleteClaim(Claim claim);

    void deleteCustomer(Customer customer);

    Set<Claim> getAllClaims();

    Set<Claim> getClaimsByCustomer(Customer c);

    Set<Customer> getCustomers();

    Set<User> getUsers();

    boolean isInsured(Customer customer);

    public void closeDatabaseConnection();
    
    public void addUser(User u);
    public User getUserByLogin(String login);
    public void clearDatabase();
    public void setClaimSeverness(Claim claim, boolean severe);
    
}
