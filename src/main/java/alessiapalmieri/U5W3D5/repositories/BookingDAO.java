package alessiapalmieri.U5W3D5.repositories;

import alessiapalmieri.U5W3D5.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingDAO extends JpaRepository<Booking, UUID> {
}
