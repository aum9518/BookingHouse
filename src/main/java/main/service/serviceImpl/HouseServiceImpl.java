package main.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.entity.House;
import main.repository.HouseRepository;
import main.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository repository;
    @Override
    public String saveHouse(House house) {
        return repository.saveHouse(house);
    }

    @Override
    public List<Agency> getAllHouses() {
        return repository.getAllHouses();
    }

    @Override
    public Agency getHouseById(Long id) {
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
