/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.view;

import com.mmse.insurance.control.Controller;
import com.mmse.insurance.model.Model;
import com.mmse.insurance.model.entities.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class AddCustomerFormTest {
    
    public AddCustomerFormTest() {
    }

    @Test
    /**
     * This is supposed to be acceptance test for adding new customer
     */
    public void testCustomerAdd() {
        Controller controller = new Controller(new Model());
        MainView view = new MainView(controller);
        controller.setView(view);
        
        assertEquals(true, view.acceptanceTestAddCustomer(new Customer("Name", "Surname", 10)));
    }
}