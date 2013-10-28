package com.mmse.insurance.model;
//test

import com.mmse.insurance.model.entities.Customer;


public class Model {

    private Database db;

    public Model() {
        db = new Database();
        testForView();
    }
    
	public Database getDb() {
        return db;
    }

    private void testForView() {
        //just for testing view
        Customer c1 = new Customer("Adam", "Klíma", 1);
        Customer c2 = new Customer("Lucas", "Sartore", 2);
        db.addCustomer(c1);
        db.addCustomer(c2);
/*
        Claim claim1 = new Claim(c1, 10.0, 10.0, ClaimState.Paid);
        Claim claim2 = new Claim(c1, 15.0, 10.0, ClaimState.Paid);
        Claim claim3 = new Claim(c2, 15.0, 10.0, ClaimState.Paid);
        db.addClaim(claim1);
        db.addClaim(claim2);
        db.addClaim(claim3);
*/		
	}


}
