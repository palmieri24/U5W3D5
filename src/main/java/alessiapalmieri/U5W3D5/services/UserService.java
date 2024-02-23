package alessiapalmieri.U5W3D5.services;

import alessiapalmieri.U5W3D5.entities.User;
import alessiapalmieri.U5W3D5.exceptions.NotFoundException;
import alessiapalmieri.U5W3D5.repositories.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UsersDAO usersDAO;

    public List<User> getUsers(){return this.usersDAO.findAll();}
    public User findById(UUID userId) {
        return usersDAO.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public User findByIdAndUpdate(UUID userId, User modifiedUser) {
        User found = this.findById(userId);
        found.setLastname(modifiedUser.getLastname());
        found.setName(modifiedUser.getName());
        found.setEmail(modifiedUser.getEmail());
        found.setPassword(modifiedUser.getPassword());
        return usersDAO.save(found);
    }

    public void findByIdAndDelete(UUID userId) {
        User found = this.findById(userId);
        usersDAO.delete(found);
    }

    public User findByEmail(String email) {
        return usersDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("Email " + email + " not found!"));
    }
}
