package main.service;

import main.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void updateCustomer(Long id, Customer newCustomer);
    void deleteCustomerById(Long id);
}
