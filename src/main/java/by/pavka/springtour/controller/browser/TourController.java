package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Tour;
import by.pavka.springtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springtours")
public class TourController {
  @Autowired TourService tourService;
  @GetMapping("")
  public String getTours(ModelMap map) {
    List<Tour> tours = tourService.getAll();
    map.addAttribute("tours", tours);
    return "tour_listing";
  }

  @GetMapping("/book")
  public String bookTour(@RequestParam String booking) {
    System.out.println("Param = " + booking);
    System.out.println(tourService.get(Integer.parseInt(booking)).get());
    return "user_info";
  }
  //
  //    @GetMapping("/{id}")
  //    public ResponseEntity<Tour> getTour(@PathVariable int id) {
  //        Tour tour = dao.getTourById(id);
  //        if (tour == null) {
  //            throw new NoSuchIDException("No such Tour ID exists");
  //        }
  //        return new ResponseEntity<>(tour, HttpStatus.OK);
  //    }
  //
  //    @PutMapping("")
  //    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour) {
  //        dao.updateTour(tour);
  //        return new ResponseEntity<>(tour, HttpStatus.OK);
  //    }
  //
  //    @PostMapping("")
  //    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
  //        dao.addTour(tour);
  //        return new ResponseEntity<>(tour, HttpStatus.CREATED);
  //    }
  //
  //    @DeleteMapping("/{id}")
  //    public HttpStatus deleteTour(@PathVariable int id) {
  //        //TODO probably needs check for id out of range, like in UserController
  //        dao.deleteTour(id);
  //         return HttpStatus.NO_CONTENT;
  //    }
}
