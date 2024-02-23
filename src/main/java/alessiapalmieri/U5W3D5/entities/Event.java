package alessiapalmieri.U5W3D5.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String title;
    private String description;
    private LocalDate date;
    private String place;
    @Column(name = "available_seats")
    private int availableSeats;
    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<Booking> bookingList;

}
