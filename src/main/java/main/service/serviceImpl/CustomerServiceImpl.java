package main.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import main.entity.Customer;
import main.repository.CustomerRepository;
import main.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    @Override
    public void saveCustomer(Customer customer) {
         repository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Long id, Customer newCustomer) {
        repository.updateCustomer(id,newCustomer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        repository.deleteCustomerById(id);
    }
}
