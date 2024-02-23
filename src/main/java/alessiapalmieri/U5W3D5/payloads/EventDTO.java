package alessiapalmieri.U5W3D5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EventDTO(
        @NotEmpty(message = "Title is mandatory!")
        @Size(min = 3, max = 30, message = "The title must have a minimum of 3 characters, a maximum of 30")
        String title,
        @NotEmpty(message = "Description is mandatory")
        @Size(min = 3, max = 30, message = "the description must have a minimum of 3 characters, a maximum of 30")
        String description,
        @NotEmpty(message = "Date is mandatory!")
        LocalDate date,
        @NotEmpty(message = "Place is mandatory!")
        @Size(min = 3, max = 30, message = "the place must have a minimum of 3 characters, a maximum of 30")
        String place,
        @NotNull(message = "places available is a mandatory field!")
        Integer availableSeats
) {}
