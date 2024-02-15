package org.example.controller;

import org.example.BLL.OrderService;
import org.example.model.Customer;
import org.example.model.Orders;
import org.example.view.EditOrderFrame;
import org.example.view.EditOrderFrame;
import org.example.view.OrderFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class EditOrderController {
    EditOrderFrame frame;
    OrderService OrderService;
    //ArrayList<Order> Orders = OrderService.getAll();
    public EditOrderController(EditOrderFrame frame){
        this.frame = frame;
        OrderService = new OrderService();
        this.frame.setEditButtonActionListener(new EditButtonActionListener());
    }
    private class EditButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Orders order = new Orders(frame.getIdField(), frame.getIdcField(), frame.getIdpField(), frame.getQuantityField(), frame.getCostField());
            OrderService.update(order);
        }
    }
}
