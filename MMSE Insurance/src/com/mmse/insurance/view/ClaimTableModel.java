/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.view;

import com.mmse.insurance.model.entities.Claim;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adam
 */
public class ClaimTableModel extends AbstractTableModel{

    private Set<Claim> claims;
    public ClaimTableModel(Set<Claim> claims) {
        this.claims = claims;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }

    
    
    
    @Override
    public int getRowCount() {
        return claims.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }    
    private Claim getClaim(int pos){
        int i = 0;
        for (Claim claim : claims) {
            if (i==pos) return claim;
            i++;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "First name";
            case 1: return "Surname";               
            case 2: return "Personal id";
            case 3: return "Car price";
            case 4: return "Damage";
            case 5: return "Severeness";
            case 6: return "State";
                
        }
        return null;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Claim c = getClaim(rowIndex);
        switch (columnIndex){
            case 0: return c.getCustomer().getFirstName();
            case 1: return c.getCustomer().getLastName();                
            case 2: return c.getCustomer().getPersonalId();
            case 3: return c.getCarPrice();
            case 4: return c.getDamagePrice();
            case 5: return c.isSevere();
            case 6: return c.getState();
                
        }
        return null;
    }
    
}
