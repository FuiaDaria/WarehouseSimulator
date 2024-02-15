package org.example.controller;

import org.example.BLL.ProductService;
import org.example.model.Product;
import org.example.view.EditProductFrame;
import org.example.view.ProductFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class EditProductController {
    EditProductFrame frame;
    ProductService ProductService;
    //ArrayList<Product> Products = ProductService.getAll();
    public EditProductController(EditProductFrame frame){
        this.frame = frame;
        ProductService = new ProductService();
        this.frame.setEditButtonActionListener(new EditButtonActionListener());
    }
    private class EditButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = new Product(frame.getIdField(), frame.getNameField(), frame.getQuantityField(), frame.getPriceField());
            ProductService.update(product);
        }
    }
}
