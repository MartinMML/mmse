package com.mmse.insurance.main;

import com.mmse.insurance.control.Controller;
import com.mmse.insurance.model.Model;
import com.mmse.insurance.view.MainView;
import java.util.Scanner;

public class Main {

    static Model model;
    static Controller controller;
    static MainView view;

    public static void main(String[] args) {
        model = new Model();
        System.out.print("Login ");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();

        System.out.print("Password ");
        String pass = sc.nextLine();
        if (model.authenticate(login, pass)) {
            controller = new Controller(model);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    MainView view = new MainView(controller);
                    view.setVisible(true);
                    controller.setView(view);
                }
            });
        }else System.out.println("Access denied!!");
    }
}
