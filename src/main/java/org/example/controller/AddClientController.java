package org.example.controller;

import org.example.BLL.CustomerService;
import org.example.model.Customer;
import org.example.view.AddClientFrame;
import org.example.view.ClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class AddClientController {
    AddClientFrame frame;
    CustomerService customerService;
    //ArrayList<Customer> clients = customerService.getAll();
    public AddClientController(AddClientFrame frame){
        this.frame = frame;
        customerService = new CustomerService();
        this.frame.setAddButtonActionListener(new AddButtonActionListener());
    }
    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer client = new Customer(frame.getNameField(), frame.getAddressField(), frame.getAgeField());
            customerService.add(client);
        }
    }
}
