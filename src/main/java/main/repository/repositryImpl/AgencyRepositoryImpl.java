package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    @PersistenceContext
        private final EntityManager entityManager ;

    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);

    }

    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("select a from Agency a",Agency.class).getResultList();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return entityManager.find(Agency.class,id);
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {
        Agency agency = entityManager.find(Agency.class, id);
        agency.setName(newAgency.getName());
        agency.setCountry(newAgency.getCountry());
        agency.setEmail(newAgency.getEmail());
        agency.setImage(newAgency.getImage());
        agency.setPhoneNumber(newAgency.getPhoneNumber());
        entityManager.merge(agency);

    }

    @Override
    public void deleteAgencyById(Long id) {
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.remove(agency);
    }

    @Override
    public List<Agency> searchAgency(String word) {
      return  entityManager.createQuery("select a from Agency a where a.name ilike :word1 " +
                        "or a.email ilike :word2 " +
                        "or a.country ilike :word3 " +
                        "or a.email ilike :word4  ", Agency.class)
                .setParameter("word1","%" + word + "%")
                .setParameter("word2","%" + word + "%")
                .setParameter("word3","%" + word + "%")
                .setParameter("word4","%" + word + "%")
                .getResultList();
    }
}
