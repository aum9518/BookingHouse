package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import main.entity.Agency;
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
    public String saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Agency> getAllCustomers() {
        return null;
    }

    @Override
    public Agency getCustomerById(Long id) {
        return null;
    }

    @Override
    public void updateCustomer(Long id, Customer newCustomer) {

    }

    @Override
    public void deleteCustomerById(Long id) {

    }
}
