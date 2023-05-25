package main.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import main.entity.Booking;
import main.repository.BookingRepository;
import main.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;


    @Override
    public List<Booking> getAllBookings() {

        return repository.getAllBookings();
    }

    @Override
    public void save(Booking booking) {
        repository.save(booking);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateBooking(Long id, Booking booking) {
        repository.updateBooking(id,booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return repository.getBookingById(id);
    }
}
