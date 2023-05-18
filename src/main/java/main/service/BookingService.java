package main.service;

import main.entity.Agency;
import main.entity.Booking;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);
    List<Agency> getAllBookings();
    Agency getBookingById(Long id);
    void updateBooking(Long id, Booking newBooking);
    void deleteBookingById(Long id);
}
