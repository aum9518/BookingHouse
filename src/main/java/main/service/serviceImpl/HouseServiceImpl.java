package main.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.House;
import main.repository.AgencyRepository;
import main.repository.HouseRepository;
import main.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository repository;
    private final AgencyRepository agencyRepository;
    @Override
    public void saveHouse(Long agencyId,House house) {
       repository.saveHouse(agencyId,house);
    }


    @Override
    public List<House> getAllHouses() {
        return repository.getAllHouses();
    }

    @Override
    public House getHouseById(Long id) {
        return repository.getHouseById(id);
    }

    @Override
    public void updateHouse(Long id, House newHouse) {
        repository.updateHouse(id, newHouse);
    }

    @Override
    public void deleteHouseById(Long id) {
        repository.deleteHouseById(id);
    }
}
