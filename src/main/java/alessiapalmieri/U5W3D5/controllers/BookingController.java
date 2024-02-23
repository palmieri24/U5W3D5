package alessiapalmieri.U5W3D5.controllers;

import alessiapalmieri.U5W3D5.entities.Booking;
import alessiapalmieri.U5W3D5.payloads.BookingDTO;
import alessiapalmieri.U5W3D5.payloads.BookingResponseDTO;
import alessiapalmieri.U5W3D5.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Booking> getPrenotazioni(){return this.bookingService.getBookings();}
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public BookingResponseDTO save(@RequestBody BookingDTO payload){
        Booking booking = bookingService.save(payload);
        return new BookingResponseDTO(booking.getId());
    }
}
