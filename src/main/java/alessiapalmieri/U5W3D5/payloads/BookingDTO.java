package alessiapalmieri.U5W3D5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record BookingDTO(
        @NotNull(message = "Event id is a mandatory field!")
        UUID event_id,
        @NotNull(message = "User id is mandatory!")
        UUID user_id
) {
}
