package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.repository.AgencyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class AgencyRepositoryImpl implements AgencyRepository {
        private final EntityManager entityManager ;

    @Override
    public String saveAgency(Agency agency) {
        return null;
    }

    @Override
    public List<Agency> getAllAgencies() {
        return null;
    }

    @Override
    public Agency getAgencyById(Long id) {
        return null;
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {

    }

    @Override
    public void deleteAgencyById(Long id) {

    }

    @Override
    public List<Agency> searchAgency(String word) {
        return null;
    }
}
