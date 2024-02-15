package org.example.BLL;
import org.example.BLL.validators.*;
import org.example.DAL.ProductRepo;
import org.example.model.Customer;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {

    private List<Validate<Product>> validators;
    private ProductRepo productRepository = new ProductRepo();

    public ProductService() {
        this.validators = new ArrayList<>();
        validators.add(new ProductQuantityValid());
        validators.add(new ProductPriceValid());
    }

    public Product getById(int id) {
        Product product = (Product) productRepository.getById(id);

        if (product == null) {
            throw new NoSuchElementException("The product with id: " + id + " was not found!");
        }

        return product;
    }

    public Product getByName(String name) {
        Product product = (Product) productRepository.getByName(name);

        if (product == null) {
            //  throw new NoSuchElementException("The product with name " + productName + " was not found!");
            return null;
        }

        return product;
    }

    public ArrayList<Product> get() {
        ArrayList<Product> products = productRepository.get();

        if (products == null) {
            throw new NoSuchElementException("There are no products!");
        }

        return products;
    }

    public int add(Product product) {
        for (Validate<Product> validator : validators) {
            validator.validate(product);
        }

        return productRepository.add(product);
    }
    public ArrayList<Product> getAll() {
        return productRepository.get();
    }

    public Product update(Product product) {
        return productRepository.update(product);
    }

    public boolean delete(int id) {
        return productRepository.delete(id);
    }
}