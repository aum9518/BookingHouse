package main.api;

import lombok.RequiredArgsConstructor;
import main.entity.Booking;
import main.entity.Customer;
import main.entity.House;
import main.service.BookingService;
import main.service.CustomerService;
import main.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingApi {
    private final BookingService service;
    private final HouseService houseService;
    private final CustomerService customerService;

    @GetMapping
    public String getAllBooking(Model model) {
        model.addAttribute("bookings", service.getAllBookings());
        return "booking";
    }

    @GetMapping("/newBookings")
    public String createHouse(Model model) {
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("houses", houseService.getAllHouses());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "newBooking";
    }

    @PostMapping("/saveBooking")
    public String saveHouse(@ModelAttribute("newBooking") Booking booking,
                            @RequestParam("house.id") Long houseId,
                            @RequestParam("customer.id") Long customerId) {
        House house = houseService.getHouseById(houseId);
        Customer customer = customerService.getCustomerById(customerId);
        booking.setHouseId(house);
        booking.setCustomerId(customer);
        service.save(booking);
        return "redirect:/bookings";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteById(id);
        return "redirect:/bookings";
    }
    @GetMapping("/update/{id}")
    public String updateBooking(@PathVariable Long id, Model model){
        Booking booking = service.getBookingById(id);
        model.addAttribute("booking",booking);
        model.addAttribute("house",houseService.getAllHouses());
        model.addAttribute("customers",customerService.getAllCustomers());
        return "updateBooking";
    }
    @PostMapping("/saveUpdate/{id}")
    public String saveBooking(@ModelAttribute("booking") Booking booking,
                              @RequestParam("houseName") Long houseId,
                              @RequestParam("customerName") Long customerId,
                              @PathVariable("id") Long id){
        House house = houseService.getHouseById(houseId);
        Customer customer = customerService.getCustomerById(customerId);
        booking.setHouseId(house);
        booking.setCustomerId(customer);
        service.updateBooking(id,booking);
        return "redirect:/bookings";
    }
}
