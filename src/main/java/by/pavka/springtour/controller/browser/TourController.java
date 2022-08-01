package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.service.BookingService;
import by.pavka.springtour.service.LibraryUserService;
import by.pavka.springtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/springtours")
public class TourController {
  @Autowired TourService tourService;
  @Autowired BookingService bookingService;
  @Autowired LibraryUserService userService;

  @GetMapping("")
  public String getTours(ModelMap map) {
    List<Tour> tours = tourService.getAllValid();
    map.addAttribute("tours", tours);
    return "tour_listing";
  }

  @Transactional
  @GetMapping("/book")
  public String bookTour(@RequestParam String booking, Principal principal) {
    int tourId = Integer.parseInt(booking);
    int userId = userService.getByUsername(principal.getName()).get().getId();
    if (!bookingService.containsByTourIdAndTouristId(tourId, userId) &&
            (tourService.incrementBooking(tourId) > 0)) {
      Booking tourBooking = new Booking();
      tourBooking.setTourId(tourId);
      tourBooking.setTouristId(userId);
      tourBooking.setPaid(false);
      bookingService.save(tourBooking);
    }
    return "redirect:/users/account";
  }

  @Transactional
  @GetMapping("/cancel")
  public String cancelBooking(@RequestParam String booking, Principal principal) {
    int tourId = Integer.parseInt(booking);
    if (tourService.decrementBooking(tourId) > 0) {
      int userId = userService.getByUsername(principal.getName()).get().getId();
      bookingService.deleteByTourIdAndTouristId(tourId, userId);
    }
    return "redirect:/users/account";
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
