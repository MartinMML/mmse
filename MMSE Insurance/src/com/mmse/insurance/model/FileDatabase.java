package com.mmse.insurance.model;

import java.util.HashSet;
import java.util.Set;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.Customer;
import com.mmse.insurance.model.entities.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Adam
 */
public class FileDatabase implements IDatabase, Serializable  {

    private String DB_PATH = "database.obj";
    /**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;
    private Set<Claim> claims = new HashSet<>();
    private Set<User> users = new HashSet<>();
    private Set<Customer> customers = new HashSet<>();

    public FileDatabase() {
        initializeDatabase();
    }

    /**
     * used only for testing purposes
     */
    public void clearDatabase(){
        claims.clear();
        users.clear();
        customers.clear();
    }
    
    
    @Override
    public Set<Claim> getAllClaims() {

        return claims;
    }

    @Override
    public Set<Claim> getClaimsByCustomer(Customer c) {
        Set<Claim> resultSet = new HashSet<>();
        for (Claim claim : claims) {
            if (claim.getCustomer().equals(c)) {
                resultSet.add(claim);
            }
        }
        return resultSet;
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public Set<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean isInsured(Customer customer) {
        return customers.contains(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }
    
    
    @Override
    public User getUserByLogin(String login){
        for (User user : users) {
            if(user.getUsername().equals(login)) return user;
        }
        return null;
    }

    @Override
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void deleteClaim(Claim claim) {
        claims.remove(claim);
        
    }

    @Override
    public void addUser(User u){
        users.add(u);
    }
    /**
     * Assuming we have one and only one Database instance, we do not specify
     * any parameter or any return value here
     */
    @Override
    public void closeDatabaseConnection() {
        try {
            FileOutputStream fileOut = new FileOutputStream(DB_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + DB_PATH);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Assuming we have one and only one Database instance, we do not specify
     * any parameter or any return value here
     */
    private void initializeDatabase() {
        FileInputStream fileIn;
        try {
            fileIn = new FileInputStream(DB_PATH);
            IDatabase database;
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                database = (FileDatabase) in.readObject();
            }
            fileIn.close();
            System.out.println("Unserialized data from " + DB_PATH);
            this.claims = database.getAllClaims();
            this.customers = database.getCustomers();
            this.users = database.getUsers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
