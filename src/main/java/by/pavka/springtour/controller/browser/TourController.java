package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourStatus;
import by.pavka.springtour.model.TourType;
import by.pavka.springtour.service.BookingService;
import by.pavka.springtour.service.LibraryUserService;
import by.pavka.springtour.service.TourService;
import by.pavka.springtour.service.TourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/springtours")
public class TourController {
  @Autowired TourService tourService;
  @Autowired BookingService bookingService;
  @Autowired LibraryUserService userService;
  @Autowired
  TourTypeService tourTypeService;

  @GetMapping("")
  public String getTours(ModelMap map) {
    List<Tour> tours = tourService.getAllValid();
    map.addAttribute("tours", tours);
    return "tour_listing";
  }

  @Transactional
  @GetMapping("/book")
  public String bookTour(@Nullable @RequestParam String booking, @Nullable @RequestParam String[] tourIds
          , Principal principal) {
    if (booking != null) {
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
    if(tourIds != null) {
      List<String> tourIdList = Arrays.asList(tourIds);
      List<Tour> tours = tourService.getAllValid();
      for (Tour t : tours) {
        if (tourIdList.contains(t.getId() + "")) {
          t.setTourStatus(TourStatus.CANCELLED);
          tourService.save(t);
        }
      }
    }
    return "redirect:/springtours";
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

  @GetMapping("/new")
  public String prepareForTour(ModelMap map) {
    map.addAttribute("tour", new Tour());
    List<TourType> types = tourTypeService.getAll();
    map.addAttribute("tourTypes", types);
    return "tour_addition";
  }

  @Transactional
  @PostMapping("/added")
  public String addTour(@ModelAttribute("tour") Tour tour) {
    tour.setTourStatus(TourStatus.VALID);
    tourService.save(tour);
    return "redirect:/springtours";
  }
}
