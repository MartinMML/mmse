package com.mmse.insurance.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mmse.insurance.model.Model;
import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.ClaimState;
import com.mmse.insurance.model.entities.Customer;
import com.mmse.insurance.view.MainView;
import com.mmse.insurance.view.dialogs.Dialog;

public class Controller {

	private Model model;
	private MainView view;

	public Controller(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setView(MainView view){
		this.view = view;
	}

	
	
	
	public void handleClaimAdd(String customerName, String customerSurname, int customerId, double carPrice, double damage ){
		Customer c = new Customer(customerName, customerSurname, customerId);
		
		if(model.getDb().isInsured(c)){            
			Claim claim = new Claim(c, carPrice, damage, ClaimState.UnApproved);
			model.getDb().addClaim(claim);
			if(view != null)view.refresh();
		}else {
			try {
				//call dialog
                                new Dialog(view, "Error", "Is not "+c.toString()+" insured Exception");                            
			} catch (Exception ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void handleCustomerAdd(String firstName, String surname, int parseInt) {
		model.getDb().addCustomer(new Customer(firstName, surname, parseInt));
		if(view != null)view.refresh();
	}

	public void handleCustomerSelect(String firstName, String surname, int parseInt) {
		Customer customer = new Customer(firstName, surname, parseInt);
		if(model.getDb().isInsured(customer)){            
			view.setClaims(model.getDb().getClaimsByCustomer(customer));
			view.refresh();
		}else{
			new Dialog(view, "Is not ensured", "This customer is not insured.");
		}

	}

	public void resetView() {
		view.setClaims(model.getDb().getAllClaims());
		view.refresh();
	}

    public void applicationClosing() {
        model.getDb().closeDatabaseConnection();
    }

}
