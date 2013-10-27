/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.ClaimState;
import com.mmse.insurance.model.entities.Customer;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @Test
    public void addCustomer(){
        Database db = new Database();
        Customer c = new Customer("Adam", "Klíma", 1);
        db.addCustomer(c);
        assertEquals(true, db.getCustomers().contains(c));
    }

    @Test
    public void addClaim(){
        Database db = new Database();
        Claim claim = new Claim(new Customer("","",1), 10.0, 10.0, ClaimState.Paid);
        db.addClaim(claim);
        assertEquals(true,db.getAllClaims().contains(claim));
    }
   

    /**
     * Test of isInsured method, of class Database.
     */
    @Test
    public void testIsInsured() {
        Database db = new Database();
        Customer c = new Customer("Adam", "Klíma", 1);
        db.addCustomer(c);
        assertEquals(true, db.isInsured(c));
    }
    
    @Test
    public void testClaimsOfCustomer(){
        Database db = new Database();
        Customer c1 = new Customer("Adam", "Klíma", 1);
        Customer c2 = new Customer("Lucas", "Sartore", 2);
        db.addCustomer(c1);
        db.addCustomer(c2);
        Claim claim1 = new Claim(c1, 10.0, 10.0, ClaimState.Paid);
        Claim claim2 = new Claim(c1, 15.0, 10.0, ClaimState.Paid);
        Claim claim3 = new Claim(c2, 15.0, 10.0, ClaimState.Paid);
        db.addClaim(claim1);
        db.addClaim(claim2);
        db.addClaim(claim3);
        Set expectedResult = new HashSet<Claim> ();
        expectedResult.add(claim1);
        expectedResult.add(claim2);
        assertEquals(expectedResult, db.getClaimsByCustomer(c1));
    }
    
    @Test
    public void testClaimsOfCustomer2(){
        Database db = new Database();
        Customer c1 = new Customer("Adam", "Klíma", 1);
        Customer c2 = new Customer("Lucas", "Sartore", 2);
        db.addCustomer(c1);
        db.addCustomer(c2);
        Claim claim1 = new Claim(c1,  10.0, 10.0, ClaimState.Paid);
        Claim claim2 = new Claim(c1, 15.0, 10.0, ClaimState.Paid);
        Claim claim3 = new Claim(c2, 15.0, 10.0, ClaimState.Paid);
        db.addClaim(claim1);
        db.addClaim(claim2);
        db.addClaim(claim3);
        Set expectedResult = new HashSet<Claim> ();
        expectedResult.add(claim3);
        assertEquals(expectedResult, db.getClaimsByCustomer(c2));
    }
}