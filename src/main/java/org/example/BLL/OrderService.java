package org.example.BLL;
import org.example.DAL.OrderRepo;
import org.example.BLL.ProductService;
import org.example.model.Orders;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderService {

    OrderRepo orderRepository = new OrderRepo();
    ProductService productService = new ProductService();

    public OrderService() {

    }

    public Orders getById(int orderId) {
        Orders orders = (Orders) orderRepository.getById(orderId);

        if (orders == null) {
            throw new NoSuchElementException("Order with id = " + orderId + " was not found!");
        }

        return orders;
    }

    public ArrayList<Orders> get() {
        ArrayList<Orders> orders = orderRepository.get();

        if (orders == null) {
            throw new NoSuchElementException("There are no orders!");
        }

        return orders;
    }

    public void decrease(Product product, int val){
        Product produs = new Product(product.getName(), product.getQuantity() - val, product.getPrice());
        productService.update(produs);
    }

    public ArrayList<Orders> getAll(){
        return orderRepository.get();
    }


    public int add(Orders order) {
        return orderRepository.add(order);
    }

    public Orders update(Orders order) {
        return orderRepository.update(order);
    }

    public boolean delete(int id) {
        return orderRepository.delete(id);
    }
}
