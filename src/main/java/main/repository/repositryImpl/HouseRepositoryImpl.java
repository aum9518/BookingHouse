package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.entity.House;
import main.repository.HouseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class HouseRepositoryImpl implements HouseRepository {
    private final EntityManager entityManager;
    @Override
    public void saveHouse(House house) {

    }

    @Override
    public List<Agency> getAllHouses() {
        return null;
    }

    @Override
    public Agency getHouseById(Long id) {
        return null;
    }

    @Override
    public void updateHouse(Long id, House newHouse) {

    }

    @Override
    public void deleteHouseById(Long id) {

    }
}
