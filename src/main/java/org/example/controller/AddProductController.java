package org.example.controller;

import org.example.BLL.ProductService;
import org.example.model.Product;
import org.example.view.AddProductFrame;
import org.example.view.ProductFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class AddProductController {
    AddProductFrame frame;
    ProductService productService;
    //ArrayList<Product> products = productService.getAll();
    public AddProductController(AddProductFrame frame){
        this.frame = frame;
        productService = new ProductService();
        this.frame.setAddButtonActionListener(new AddButtonActionListener());
    }
    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product produs = new Product(frame.getNameField(), frame.getQuantityField(), frame.getPriceField());
            productService.add(produs);
        }
    }
}
