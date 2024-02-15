package org.example.BLL.validators;

import org.example.model.Product;
public class ProductPriceValid implements Validate<Product> {

    @Override
    public void validate(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Invalid product price: price must be > 0");
        }
    }
}
