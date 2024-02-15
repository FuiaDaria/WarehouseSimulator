package org.example.BLL.validators;
import org.example.model.Customer;

import java.util.regex.Pattern;

public class CustomerNameValid implements Validate<Customer> {

    private static final String NAME_PATTERN = "^[a-z A-Z]+$";

    @Override
    public void validate(Customer customer) {
        if (customer.getName().length() <= 30) {
            Pattern pattern = Pattern.compile(NAME_PATTERN);
            if (!pattern.matcher(customer.getName()).matches()) {
                throw new IllegalArgumentException("Invalid customer name");
            }
        } else {
            throw new IllegalArgumentException("Invalid customer name");
        }
    }
}