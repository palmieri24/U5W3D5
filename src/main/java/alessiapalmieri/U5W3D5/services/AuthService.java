package alessiapalmieri.U5W3D5.services;

import alessiapalmieri.U5W3D5.Enum.Role;
import alessiapalmieri.U5W3D5.entities.User;
import alessiapalmieri.U5W3D5.exceptions.BadRequestException;
import alessiapalmieri.U5W3D5.exceptions.UnauthorizedException;
import alessiapalmieri.U5W3D5.payloads.UserDTO;
import alessiapalmieri.U5W3D5.payloads.UserLoginDTO;
import alessiapalmieri.U5W3D5.repositories.UsersDAO;
import alessiapalmieri.U5W3D5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private PasswordEncoder bcrypt;

    public String authenticateUser(UserLoginDTO body){
        User user = userService.findByEmail(body.email());
        if(bcrypt.matches(body.password(), user.getPassword())){
            return jwtTools.createToken(user);

        }else{
            throw new UnauthorizedException("Invalid credentials!");
        }

    }
    public User save(UserDTO body){
        usersDAO.findByEmail(body.email()).ifPresent(user -> {throw new BadRequestException("email " + user.getEmail() + " already in use!");});
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setLastname(body.lastname());
        newUser.setEmail(body.email());
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setRole(Role.USER);
        return usersDAO.save(newUser);
    }
}
