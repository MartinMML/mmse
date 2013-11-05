/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.view;

import com.mmse.insurance.control.Controller;
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
public class ClaimInputFormTest {
    
    public ClaimInputFormTest() {
    }

    @Test
    public void testClaimAdd() {
        
        Model model = new Model();
        model.authenticate("adam", "pass");
        Controller controller = new Controller(model);
        MainView view = new MainView(controller);
        controller.setView(view);
        
        assertEquals(true, view.acceptanceTestAddClaim(new Claim(new Customer("Name", "Surname", 10),1.2,1.4, ClaimState.UnApproved)));
    }
}