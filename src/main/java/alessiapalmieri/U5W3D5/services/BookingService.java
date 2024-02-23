package alessiapalmieri.U5W3D5.services;

import alessiapalmieri.U5W3D5.entities.Booking;
import alessiapalmieri.U5W3D5.entities.Event;
import alessiapalmieri.U5W3D5.entities.User;
import alessiapalmieri.U5W3D5.exceptions.NotFoundException;
import alessiapalmieri.U5W3D5.payloads.BookingDTO;
import alessiapalmieri.U5W3D5.repositories.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    public List<Booking> getBookings(){return this.bookingDAO.findAll();}

    public Booking save(BookingDTO body){
        User user = userService.findById(body.user_id());
        Event event = eventService.findById(body.event_id());
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        return bookingDAO.save(booking);
    }
    public Booking findById(UUID id){
        return bookingDAO.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Booking findByIdAndUpdate(UUID id, BookingDTO body){
        Booking found = this.findById(id);
        User user = userService.findById(body.user_id());
        Event event = eventService.findById(body.event_id());
        found.setEvent(event);
        found.setUser(user);
        return bookingDAO.save(found);
    }

    public void findByIdAndDelete(UUID id){
        Booking found = this.findById(id);
        bookingDAO.delete(found);
    }

}
