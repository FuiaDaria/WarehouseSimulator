package org.example.controller;

import org.example.BLL.CustomerService;
import org.example.model.Customer;
import org.example.view.EditClientFrame;
import org.example.view.ClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class EditClientController {
    EditClientFrame frame;
    CustomerService customerService;
    //ArrayList<Customer> clients = customerService.getAll();
    public EditClientController(EditClientFrame frame){
        this.frame = frame;
        customerService = new CustomerService();
        this.frame.setEditButtonActionListener(new EditButtonActionListener());
    }
    private class EditButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer client = new Customer(frame.getIdField(), frame.getNameField(), frame.getAddressField(), frame.getAgeField());
            customerService.update(client);
        }
    }
}
