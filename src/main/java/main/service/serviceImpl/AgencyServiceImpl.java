package main.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.repository.AgencyRepository;
import main.service.AgencyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository repository;
    @Override
    public void saveAgency(Agency agency) {
       repository.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return repository.getAllAgencies();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return repository.getAgencyById(id);
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {
        repository.updateAgency(id, newAgency);
    }

    @Override
    public void deleteAgencyById(Long id) {
        repository.deleteAgencyById(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return repository.searchAgency(word);
    }
}
