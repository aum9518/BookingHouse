package main.repository;

import main.entity.Agency;
import main.entity.House;

import java.util.List;

public interface HouseRepository {
    void saveHouse(House house);
    List<Agency> getAllHouses();
    Agency getHouseById(Long id);
    void updateHouse(Long id, House newHouse);
    void deleteHouseById(Long id);
}
