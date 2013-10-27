/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmse.insurance.view;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.Customer;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adam
 */
public class CustomerTableModel extends AbstractTableModel{

    private Set<Customer> customers;
    public CustomerTableModel(Set<Customer> customers) {
        this.customers = customers;
    }

    
    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }    
   
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "First name";
            case 1: return "Surname";               
            case 2: return "Personal id";
                
        }
        return null;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = getCustomer(rowIndex);
        switch (columnIndex){
            case 0: return c.getFirstName();
            case 1: return c.getLastName();                
            case 2: return c.getPersonalId();
                
        }
        return null;
    }

    private Customer getCustomer(int rowIndex) {
        int i = 0;
        for (Customer customer : customers) {
            if (i==rowIndex) return customer;
            i++;
        }
        return null;
    }
    
}
