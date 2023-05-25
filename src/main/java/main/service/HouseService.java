package main.service;

import main.entity.House;

import java.util.List;

public interface HouseService {
    public void saveHouse(Long agencyId,House house);
    List<House> getAllHouses();
    House getHouseById(Long id);
    void updateHouse(Long id, House newHouse);
    void deleteHouseById(Long id);
}
