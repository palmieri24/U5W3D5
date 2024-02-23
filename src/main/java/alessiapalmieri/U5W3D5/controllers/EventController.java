package alessiapalmieri.U5W3D5.controllers;

import alessiapalmieri.U5W3D5.entities.Event;
import alessiapalmieri.U5W3D5.payloads.EventDTO;
import alessiapalmieri.U5W3D5.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getEvents(){return this.eventService.getEvents();}
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Event save(@RequestBody EventDTO body){
        return eventService.save(body);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Event uploadEvent(@PathVariable UUID id, @RequestBody Event body){
        return eventService.findByIdAndUpdate(id, body);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteEvent(@PathVariable UUID id){
        eventService.findByIdAndDelete(id);
    }
}
