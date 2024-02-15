package org.example.BLL;
import org.example.BLL.validators.*;
import org.example.DAL.CustomerRepo;
import org.example.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
public class CustomerService {

    private List<Validate<Customer>> validators;
    private CustomerRepo customerRepository;

    public CustomerService() {
        validators = new ArrayList<Validate<Customer>>();
        validators.add(new CustomerNameValid());
        validators.add(new CustomerAddressValid());
        this.customerRepository = new CustomerRepo();
    }

    public Customer getById(int id) {
        Customer customer = (Customer) this.customerRepository.getById(id);

        if (customer == null) {
            throw new NoSuchElementException("The customer with id = " + id + " was not found!");
        }

        return customer;
    }
    public Customer getByName(String name) {
        Customer customer = (Customer) this.customerRepository.getByName(name);

        if (customer == null) {
            throw new NoSuchElementException("The customer with name: " + name + " was not found!");
        }

        return customer;
    }

    public ArrayList<Customer> get() {
        ArrayList<Customer> customers = this.customerRepository.get();

        if (customers == null) {
            throw new NoSuchElementException("There are no customers!");
        }

        return customers;
    }
    public ArrayList<Customer> getAll() {
        return customerRepository.get();
    }

    public int add(Customer customer) {
        for (Validate<Customer> validator : validators) {
            validator.validate(customer);
        }

        return this.customerRepository.add(customer);
    }

    public Customer update(Customer customer) {
        return this.customerRepository.update(customer);
    }

    public boolean delete(int id) {
        return this.customerRepository.delete(id);
    }
}