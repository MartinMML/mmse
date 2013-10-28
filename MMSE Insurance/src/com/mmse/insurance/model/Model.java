package com.mmse.insurance.model;
//test

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mmse.insurance.model.entities.Claim;
import com.mmse.insurance.model.entities.ClaimState;
import com.mmse.insurance.model.entities.Customer;


public class Model {

	private String DB_PATH = "database.obj";
	private Database db;

	public Model() {
		db = new Database();

		// testForView();
		
		loadDatabase();
		
	}

	/**
	 * Assuming we have one and only one Database instance, we do not specify any parameter or any return value here
	 */
	public void saveDatabase() {
		try {
			FileOutputStream fileOut = new FileOutputStream(DB_PATH);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(db);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in "+ DB_PATH);
		}catch(IOException i) {
			i.printStackTrace();
		}
	}

	/**
	 * Assuming we have one and only one Database instance, we do not specify any parameter or any return value here
	 */
	private void loadDatabase() {
		db = null;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(DB_PATH);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			db = (Database) in.readObject();

			in.close();
			fileIn.close();
			System.out.println("Unserialized data from "+ DB_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Database getDb() {
		return db;
	}

	private void testForView() {
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


}
