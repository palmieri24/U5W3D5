package alessiapalmieri.U5W3D5.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'utente con id " + id + " non è stato trovato");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
