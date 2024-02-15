package org.example.controller;
import org.example.BLL.OrderService;
import org.example.model.Orders;
import org.example.model.Orders;
import org.example.view.DeleteOrderFrame;
import org.example.view.OrderFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteOrderController {
    DeleteOrderFrame frame;
    OrderService OrderService;
    //ArrayList<Order> Orders = OrderService.getAll();
    public DeleteOrderController(DeleteOrderFrame frame){
        this.frame = frame;
        OrderService = new OrderService();
        this.frame.setDeleteButtonActionListener(new DeleteButtonActionListener());
    }
    private class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderService.delete(frame.getIdField());
        }
    }
}
