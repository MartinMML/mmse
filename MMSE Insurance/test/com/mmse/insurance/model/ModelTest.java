/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.model;

import com.mmse.insurance.model.entities.Role;
import com.mmse.insurance.model.entities.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class ModelTest {
    
    public ModelTest() {
    }

    @Test
    public void testAuthenticationTrue() {
        Model model = new Model();
        model.getDb().clearDatabase();
        User user = new User("adam", "1234", Role.CarDept);
        model.getDb().addUser(user);
        assertEquals(true, model.authenticate("adam", "1234"));
        assertEquals(model.getAuthenticatedRole(), user.getRole());
    }
    
    @Test
    public void testAuthenticationFalse() {
        Model model = new Model();
        User user = new User("adam", "1234", Role.CarDept);
        model.getDb().addUser(user);
        assertEquals(false, model.authenticate("adam", "123"));
        assertEquals(model.getAuthenticatedRole(), Role.NotAuthenticated);
    }
    
    @Test
    public void testAuthenticationNotExist() {
        Model model = new Model();
        assertEquals(false, model.authenticate("adam", "123"));
    }
    
}