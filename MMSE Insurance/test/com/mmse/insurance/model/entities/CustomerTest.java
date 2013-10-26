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
public class CustomerTest {
    
    public CustomerTest() {
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testConstruction(){
        Customer c = new Customer("Adam" , "Klíma", 1);
        assertEquals("Adam", c.getFirstName());
        assertEquals("Klíma", c.getLastName());
        assertEquals(1, c.getPersonalId());
    }
}