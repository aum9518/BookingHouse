package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Booking;
import main.entity.Customer;
import main.entity.House;
import main.repository.BookingRepository;
import main.repository.CustomerRepository;
import main.repository.HouseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {
    private final HouseRepository houseRepository;
    private final CustomerRepository customerRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Booking> getAllBookings() {
        return entityManager.createQuery("select b from Booking b",Booking.class).getResultList();
    }

    @Override
    public void save(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public void deleteById(Long id) {
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }

    @Override
    public void updateBooking(Long id, Booking booking) {
        Booking booking1 = entityManager.find(Booking.class, id);
        booking1.setCustomerId(booking.getCustomerId());
        booking1.setHouseId(booking.getHouseId());
        entityManager.merge(booking1);
    }

    @Override
    public Booking getBookingById(Long id) {
        return entityManager.find(Booking.class,id);
    }

}
