package main.repository;

import main.entity.Booking;

import java.util.List;

public interface BookingRepository {
   List<Booking> getAllBookings();
   void save(Booking booking);
   void deleteById(Long id);
   void updateBooking(Long id,Booking booking);
   Booking getBookingById(Long id);
}
