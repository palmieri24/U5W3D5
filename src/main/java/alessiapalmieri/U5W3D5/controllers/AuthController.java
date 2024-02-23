package alessiapalmieri.U5W3D5.controllers;

import alessiapalmieri.U5W3D5.entities.User;
import alessiapalmieri.U5W3D5.exceptions.BadRequestException;
import alessiapalmieri.U5W3D5.payloads.LoginResponseDTO;
import alessiapalmieri.U5W3D5.payloads.UserDTO;
import alessiapalmieri.U5W3D5.payloads.UserLoginDTO;
import alessiapalmieri.U5W3D5.payloads.UserResponseDTO;
import alessiapalmieri.U5W3D5.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserLoginDTO body){
        String accessToken = authService.authenticateUser(body);
        return new LoginResponseDTO(accessToken);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody @Validated UserDTO newUserPayload, BindingResult validation) {
        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException(validation.getAllErrors());
        } else {
            User newUser = authService.save(newUserPayload);
            return new UserResponseDTO(newUser.getId());
        }
    }
}
