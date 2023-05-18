package main.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import main.entity.Agency;
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
    public String saveBooking(Booking booking) {
        return repository.saveBooking(booking);
    }

    @Override
    public List<Agency> getAllBookings() {
        return repository.getAllBookings();
    }

    @Override
    public Agency getBookingById(Long id) {
        return repository.getBookingById(id);
    }

    @Override
    public void updateBooking(Long id, Booking newBooking) {
        repository.updateBooking(id,newBooking);
    }

    @Override
    public void deleteBookingById(Long id) {
        repository.deleteBookingById(id);
    }
}
