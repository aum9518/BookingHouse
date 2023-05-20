package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Customer;
import main.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
        private final EntityManager entityManager ;
    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c",Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public void updateCustomer(Long id, Customer newCustomer) {
        Customer customer = entityManager.find(Customer.class, id);
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        customer.setGender(newCustomer.getGender());
        customer.setDateOfBirth(newCustomer.getDateOfBirth());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }
}
