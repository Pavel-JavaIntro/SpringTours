package by.pavka.springtour.controller.rest;

import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourType;
import by.pavka.springtour.service.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tourTypes")
public class TourTypeRestController {

    @Autowired
    TourTypeService service;

    @GetMapping("")
    public List<TourType> getAll() {
        List<TourType> tours = service.getAll();
        return tours;
    }

    @GetMapping("/{id}")
    public TourType get(@PathVariable int id) {
        return service.get(id).get();
    }

    @PutMapping("")
    public TourType update(@RequestBody TourType tour) {
        return service.save(tour);
    }

    @PostMapping("")
    public TourType add(@RequestBody TourType tour) {
        return service.save(tour);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable int id) {
        service.delete(id);
    }
}
