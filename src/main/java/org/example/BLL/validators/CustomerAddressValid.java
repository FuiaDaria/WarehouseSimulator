package org.example.BLL.validators;
import java.util.regex.Pattern;
import org.example.model.Customer;

public class CustomerAddressValid implements Validate<Customer> {

    private static final String ADDRESS_PATTERN = "^[a-z, A-Z.-0-9]+$";

    @Override
    public void validate(Customer customer) {
        if (customer.getAddress().length() <= 45) {
            Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
            if (!pattern.matcher(customer.getAddress()).matches()) {
                throw new IllegalArgumentException("Invalid customer address");
            }
        } else {
            throw new IllegalArgumentException("Invalid customer address");
        }
    }
}
