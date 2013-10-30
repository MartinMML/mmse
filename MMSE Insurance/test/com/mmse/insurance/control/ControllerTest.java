/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.control;

import com.mmse.insurance.model.Model;
import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.ClaimState;
import com.mmse.insurance.model.entities.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class ControllerTest {
    
    public ControllerTest() {
    }

   

    /**
     * Test of handleClaimAdd method, of class Controller.
     */
    @Test
    public void testHandleClaimAdd() {
        Model model = new Model(true);
        Controller instance = new Controller(model);
        Customer customer = new Customer("Adam", "Klíma", 1);
        model.getDb().addCustomer(customer);
        instance.handleClaimAdd("Adam", "Klíma", 1, 132.1, 13.8);
        Claim c = new Claim( customer,132.1, 13.8, ClaimState.Paid);
        
        assertEquals(c.getCustomer(),model.getDb().getAllClaims().iterator().next().getCustomer() );
        assertEquals(c.getCarPrice(),model.getDb().getAllClaims().iterator().next().getCarPrice(), 0);
        assertEquals(c.getDamagePrice(),model.getDb().getAllClaims().iterator().next().getDamagePrice(), 0 );
        
    }
    
    @Test
    public void testHandleCustomerAdd() {        
        Model model = new Model(true);
        Controller controller = new Controller(model);        
        Customer customer = new Customer("Adam", "Klíma", 3);
        controller.handleCustomerAdd("Adam", "Klíma", 3);
        assertEquals(true, model.getDb().isInsured(customer));
    }
}