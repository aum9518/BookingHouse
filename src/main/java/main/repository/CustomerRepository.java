package main.repository;

import main.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void updateCustomer(Long id, Customer newCustomer);
    void deleteCustomerById(Long id);
    void assignCustomerToAgency(Long customerId, Long agencyId);
}
