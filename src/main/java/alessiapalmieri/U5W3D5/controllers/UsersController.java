package alessiapalmieri.U5W3D5.controllers;

import alessiapalmieri.U5W3D5.entities.Booking;
import alessiapalmieri.U5W3D5.entities.User;
import alessiapalmieri.U5W3D5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUtenti(){return this.userService.getUsers();}
    @GetMapping("/me")
    public User getUser(@AuthenticationPrincipal User user) {
        return user;
    }
    @GetMapping("/me/bookings")
    public List<Booking> getUserBookings(@AuthenticationPrincipal User user){return user.getBookingList();}
}
