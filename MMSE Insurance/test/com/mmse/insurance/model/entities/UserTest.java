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
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of constructor and getters, of class User.
     */
    @Test
    public void testGetUsername() {
        User u = new User("login", "hash", Role.CarDept);
        assertEquals(Role.CarDept, u.getRole());
        assertEquals("login", u.getUsername());
        assertEquals("hash", u.getPasswordHash());
    }

    
}