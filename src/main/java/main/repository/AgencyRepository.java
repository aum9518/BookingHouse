package main.repository;

import main.entity.Agency;

import java.util.List;

public interface AgencyRepository {
    String saveAgency(Agency agency);
    List<Agency> getAllAgencies();
    Agency getAgencyById(Long id);
    void updateAgency(Long id, Agency newAgency);
    void deleteAgencyById(Long id);
    List<Agency> searchAgency(String word);
}
