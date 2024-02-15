package org.example.controller;
import org.example.BLL.ProductService;
import org.example.model.Product;
import org.example.model.Product;
import org.example.view.DeleteProductFrame;
import org.example.view.ProductFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteProductController {
    DeleteProductFrame frame;
    ProductService productService;
    //ArrayList<Product> Products = ProductService.getAll();
    public DeleteProductController(DeleteProductFrame frame){
        this.frame = frame;
        productService = new ProductService();
        this.frame.setDeleteButtonActionListener(new DeleteButtonActionListener());
    }
    private class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productService.delete(frame.getIdField());
        }
    }
}
