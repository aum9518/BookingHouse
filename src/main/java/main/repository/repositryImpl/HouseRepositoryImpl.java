package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void saveHouse(House house) {
        entityManager.persist(house);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("select h from House h",House.class).getResultList();
    }

    @Override
    public House getHouseById(Long id) {
        return entityManager.find(House.class, id);
    }

    @Override
    public void updateHouse(Long id, House newHouse) {
        House house = entityManager.find(House.class, id);
        house.setAddress(newHouse.getAddress());
        house.setCountry(newHouse.getCountry());
        house.setDescription(newHouse.getDescription());
        house.setHouseType(newHouse.getHouseType());
        house.setIsBooked(newHouse.getIsBooked());
        house.setPrice(newHouse.getPrice());
        house.setRoom(newHouse.getRoom());
        house.setAgency(newHouse.getAgency());
            }

    @Override
    public void deleteHouseById(Long id) {
        House house = entityManager.find(House.class, id);
        entityManager.remove(house);
    }
}
