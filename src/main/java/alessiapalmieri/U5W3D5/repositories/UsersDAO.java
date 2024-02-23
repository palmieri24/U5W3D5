package alessiapalmieri.U5W3D5.repositories;

import alessiapalmieri.U5W3D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersDAO extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
