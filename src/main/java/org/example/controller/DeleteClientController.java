package org.example.controller;
import org.example.BLL.CustomerService;
import org.example.model.Customer;
import org.example.view.DeleteClientFrame;
import org.example.view.ClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DeleteClientController {
    DeleteClientFrame frame;
    CustomerService customerService;
    //ArrayList<Customer> clients = customerService.getAll();
    public DeleteClientController(DeleteClientFrame frame){
        this.frame = frame;
        customerService = new CustomerService();
        this.frame.setDeleteButtonActionListener(new DeleteButtonActionListener());
    }
    private class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerService.delete(frame.getIdField());
        }
    }
}
