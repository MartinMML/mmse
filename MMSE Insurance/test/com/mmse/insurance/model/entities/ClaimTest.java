/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class ClaimTest {
    
    public ClaimTest() {
    }

    @Test
    public void testCreation() {
        Claim c = new Claim(1, new Customer("","",1), false, 10.0, 10.0, ClaimState.Paid);
        assertEquals(1, c.getId());
        assertEquals(new Customer("","",1), c.getCustomer());
        assertEquals(false, c.isSevere());
        assertEquals(10.0, c.getCarPrice(),0);
        assertEquals(10.0, c.getDamagePrice(),0);        
        assertEquals(ClaimState.Paid, c.getState());
        
    }
}