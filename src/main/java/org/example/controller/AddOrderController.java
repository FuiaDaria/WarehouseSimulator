package org.example.controller;
import org.example.BLL.BillService;
import org.example.BLL.OrderService;
import org.example.BLL.ProductService;
import org.example.DAL.BillRepo;
import org.example.model.Bill;
import org.example.model.Orders;
import org.example.model.Product;
import org.example.view.AddOrderFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddOrderController {
    AddOrderFrame frame;
    OrderService orderService;
    BillService billService;
    ProductService productService;
    //ArrayList<Comanda> Orders = ComandaService.getAll();
    public AddOrderController(AddOrderFrame frame){
        this.frame = frame;
        orderService = new OrderService();
        billService = new BillService();
        productService = new ProductService();
        this.frame.setAddButtonActionListener(new AddButtonActionListener());
    }
    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Product> products;
            products = productService.getAll();
            int cost = productService.getById(frame.getIdpField()).getPrice() * frame.getQuantityField();
            Orders order = new Orders(frame.getIdcField(), frame.getIdpField(), frame.getQuantityField(), cost);
            //Bill nota = new Bill(order.getId(), frame.getQuantityField());
            orderService.add(order);
            //billService.add(nota);
            if(products.get(frame.getIdpField()).getQuantity() - frame.getQuantityField() < 0){
                System.out.println(products.get(frame.getIdpField()).getQuantity() - frame.getQuantityField());
                frame.setPossibleField("Impossible to order that");
            }else {
                orderService.decrease(products.get(frame.getIdpField()-1), frame.getIdpField());
            }
        }

    }
}