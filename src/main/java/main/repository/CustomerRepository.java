package main.repository;

import main.entity.Agency;
import main.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    String saveCustomer(Customer customer);
    List<Agency> getAllCustomers();
    Agency getCustomerById(Long id);
    void updateCustomer(Long id, Customer newCustomer);
    void deleteCustomerById(Long id);
}
