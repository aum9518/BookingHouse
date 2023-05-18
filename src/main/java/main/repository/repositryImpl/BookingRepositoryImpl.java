package main.repository.repositryImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Agency;
import main.entity.Booking;
import main.repository.BookingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;
    @Override
    public String saveBooking(Booking booking) {
        return null;
    }

    @Override
    public List<Agency> getAllBookings() {
        return null;
    }

    @Override
    public Agency getBookingById(Long id) {
        return null;
    }

    @Override
    public void updateBooking(Long id, Booking newBooking) {

    }

    @Override
    public void deleteBookingById(Long id) {

    }
}
