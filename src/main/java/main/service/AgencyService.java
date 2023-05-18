package main.service;

import main.entity.Agency;

import java.util.List;

public interface AgencyService {

    String saveAgency(Agency agency);
    List<Agency> getAllAgencies();
    Agency getAgencyById(Long id);
    void updateAgency(Long id, Agency newAgency);
    void deleteAgencyById(Long id);
    List<Agency> searchAgency(String word);
}
