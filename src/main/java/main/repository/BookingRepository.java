package main.repository;

import main.entity.Agency;
import main.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);
    List<Agency> getAllBookings();
    Agency getBookingById(Long id);
    void updateBooking(Long id, Booking newBooking);
    void deleteBookingById(Long id);
}
