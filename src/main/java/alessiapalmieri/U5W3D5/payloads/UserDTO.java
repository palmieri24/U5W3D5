package alessiapalmieri.U5W3D5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotEmpty(message = "Name is a required field")
        @Size(min = 4, max = 30, message = "The name must be between 4 and 30 characters")
        String name,
        @NotEmpty(message = "Lastname is a required field!")
        @Size(min = 4, max = 30, message = "The surname must be between 4 and 30 characters")
        String lastname,
        @NotEmpty(message = "The email is a required field!")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "The email entered is invalid")
        String email,
        @NotEmpty(message = "Password is a required field!")
        @Size(min = 8, max = 16, message = "The password must be between 8 and 16 characters!")
        String password
) {
}
