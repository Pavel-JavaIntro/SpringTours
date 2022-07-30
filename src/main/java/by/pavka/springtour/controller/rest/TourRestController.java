package by.pavka.springtour.controller.rest;

import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourType;
import by.pavka.springtour.service.TourService;
import by.pavka.springtour.service.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tours")
public class TourRestController {

  @Autowired TourService service;
  @Autowired TourTypeService typeService;

  @GetMapping("")
  public List<Tour> getAll() {
    List<Tour> tours = service.getAll();
    return tours;
  }

  @GetMapping("/{id}")
  public Tour get(@PathVariable int id) {
    return service.get(id).get();
  }

  @PutMapping("")
  public Tour update(@RequestBody Tour tour) {
    return service.save(tour);
  }

  @PostMapping("")
  public Tour add(@RequestBody Tour tour) {
    List<TourType> types = typeService.getAll();
    TourType tourType = tour.getTourType();
    System.out.println("Still checking");
    if (!types.contains(tourType)) {
      System.out.println("Checked");
      typeService.save(tourType);
    }
    return service.save(tour);
  }

  @DeleteMapping("/{id}")
  public void deleteTour(@PathVariable int id) {
    service.delete(id);
  }
}
