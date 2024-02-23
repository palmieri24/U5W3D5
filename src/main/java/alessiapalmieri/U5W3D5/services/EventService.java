package alessiapalmieri.U5W3D5.services;

import alessiapalmieri.U5W3D5.entities.Event;
import alessiapalmieri.U5W3D5.exceptions.NotFoundException;
import alessiapalmieri.U5W3D5.payloads.EventDTO;
import alessiapalmieri.U5W3D5.repositories.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventDAO eventDAO;

    public List<Event> getEvents(){return this.eventDAO.findAll();}
    public Event findById(UUID id){return eventDAO.findById(id).orElseThrow(()->new NotFoundException(id));}
    public Event findByIdAndUpdate(UUID id, Event body){
        Event found = this.findById(id);
       found.setTitle(body.getTitle());
       found.setDate(body.getDate());
       found.setPlace(body.getPlace());
       found.setDescription(body.getDescription());
       found.setAvailableSeats(body.getAvailableSeats());

        return eventDAO.save(found);
    }

    public void findByIdAndDelete(UUID id){
        Event found = this.findById(id);
        eventDAO.delete(found);
    }

    public Event save(EventDTO payload){
        Event newEvent = new Event();
        newEvent.setTitle(payload.title());
        newEvent.setDate(payload.date());
        newEvent.setDescription(payload.description());
        newEvent.setPlace(payload.place());
        newEvent.setAvailableSeats(payload.availableSeats());
        return eventDAO.save(newEvent);
    }
}
