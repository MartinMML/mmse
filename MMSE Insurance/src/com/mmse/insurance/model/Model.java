package com.mmse.insurance.model;
//test

import com.mmse.insurance.model.entities.Role;
import com.mmse.insurance.model.entities.User;

public class Model {

    private IDatabase db;
    private Role authenticatedRole;
    private User authenticatedUser;
    

    public Model() {
        this.authenticatedRole = Role.NotAuthenticated;
        this.authenticatedUser = null;
        
        db = new FileDatabase();
        
        db.addUser(new User("root", "pass", Role.ClaimHandlerA));
    }

    public Role getAuthenticatedRole() {
        return authenticatedRole;
    }
    
    

    public IDatabase getDb() {
        return db;
    }

    public boolean authenticate(String login, String password) {
        User user = db.getUserByLogin(login);
        if (user!=null){
            if(user.getPasswordHash().equals(password)){
                authenticatedRole = user.getRole();
                authenticatedUser = user;
                return true;
            }
            else return false;
        }
        else return false;
       
    }
    
    public User getAuthenticatedUser(){
        return authenticatedUser;
    }

    /*private void testForView() {
     Customer c1 = new Customer("Adam", "Klima", 1);
     Customer c2 = new Customer("Lucas", "Sartore", 2);
     Customer c3 = new Customer("John", "Doe", 3);
     Customer c4 = new Customer("George", "Washington", 4);
     Customer c5 = new Customer("Barrack", "Obama", 5);
     Customer c6 = new Customer("Erik", "Ericsson", 6);
		
     db.addCustomer(c1);
     db.addCustomer(c2);
     db.addCustomer(c3);
     db.addCustomer(c4);
     db.addCustomer(c5);
     db.addCustomer(c6);
		
     Claim claim1 = new Claim(c1, 10525.0, 18000.0, ClaimState.UnApproved);
     Claim claim2 = new Claim(c1, 15224.0, 250.0, ClaimState.UnApproved);
     Claim claim3 = new Claim(c1, 23846.0, 1000000.0, ClaimState.UnApproved);
     Claim claim4 = new Claim(c2, 1800000.0, 1.0, ClaimState.Paid);
     db.addClaim(claim1);
     db.addClaim(claim2);
     db.addClaim(claim3);
     db.addClaim(claim4);
		
     saveDatabase();
     }

     */
}
