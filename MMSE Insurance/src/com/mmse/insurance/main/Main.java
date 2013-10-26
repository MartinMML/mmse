package com.mmse.insurance.main;

import com.mmse.insurance.control.Controller;
import com.mmse.insurance.model.Model;
import com.mmse.insurance.view.MainView;

public class Main {
	
	static Model model;
	static Controller controller;
	static MainView view;
	
	
	public static void main(String[] args) {
		model = new Model();
		controller = new Controller(model);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MainView(controller).setVisible(true);
                    }
                });
	}
	
	/**
	 * Function added just for trying JUnit testing
	 */
	public int add(int a, int b) {
		return a+b;
	}

}
