package org.example.BLL.validators;
import org.example.model.Product;

public class ProductQuantityValid implements Validate<Product>{
    @Override
    public void validate(Product product) {
        if (product.getQuantity() < 0) {
            throw new IllegalArgumentException("Invalid product price: quantity must be > 0");
        }
    }
}
