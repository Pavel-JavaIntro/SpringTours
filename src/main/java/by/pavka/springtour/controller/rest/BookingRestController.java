package by.pavka.springtour.controller.rest;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.model.TourType;
import by.pavka.springtour.service.BookingService;
import by.pavka.springtour.service.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingRestController {
    @Autowired
    BookingService service;

    @GetMapping("")
    public List<Booking> getAll() {
        List<Booking> bookings = service.getAll();
        return bookings;
    }

    @GetMapping("/{id}")
    public Booking get(@PathVariable int id) {
        return service.get(id).get();
    }

    @PutMapping("")
    public Booking update(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @PostMapping("")
    public Booking add(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable int id) {
        service.delete(id);
    }
}
