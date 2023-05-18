package main.repository;

import main.entity.Agency;
import main.entity.Booking;
import main.entity.House;

import java.util.List;

public interface BookingRepository {
    String saveBooking(Booking booking);
    List<Agency> getAllBookings();
    Agency getBookingById(Long id);
    void updateBooking(Long id, Booking newBooking);
    void deleteBookingById(Long id);
}
