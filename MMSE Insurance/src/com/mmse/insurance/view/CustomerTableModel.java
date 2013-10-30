package com.mmse.insurance.view;

import java.util.Set;

import javax.swing.table.AbstractTableModel;

import com.mmse.insurance.model.entities.Customer;

/**
 *
 * @author Adam
 */
@SuppressWarnings("serial")
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
    
    public boolean contains(Customer customer){
        if(customers.contains(customer)) return true;
        else return false;
    }
    
}
