package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.service.BookingService;
import by.pavka.springtour.service.LibraryUserService;
import by.pavka.springtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("users")
public class LibraryUserController {

  @Autowired LibraryUserService userService;
  @Autowired
  BookingService bookingService;
  @Autowired TourService tourService;

  @GetMapping
  public String showAllUsers(@Nullable @RequestParam String[] userId, ModelMap map) {
    List<LibraryUser> users = userService.getAll();
    if (userId != null) {
      List<String> userIds = Arrays.asList(userId);
      for (LibraryUser u : users) {
        if (userIds.contains(u.getId() + "")) {
          u.setEnabled(1);
        } else {
          u.setEnabled(0);
        }
        userService.save(u);
      }
    }

    map.addAttribute("users", users);
    return "user_listing";
  }

  @Transactional
  @GetMapping("/account")
  public String showPersonalAccount(ModelMap map, Principal principal) {
    LibraryUser user = userService.getByUsername(principal.getName()).get();
    int userId = user.getId();
    List<Booking> bookings = bookingService.findByTouristId(userId);
    List<Tour> tours = new ArrayList<>();
    for (Booking b : bookings) {
      Tour tour = tourService.get(b.getTourId()).get();
      tours.add(tour);
    }
    map.addAttribute("user", user);
    map.addAttribute("tours", tours);
    return "user_info";
  }
//
//  @PostMapping
//  public String registerNewTourist(LibraryUser tourist, ModelMap map) {
//    // TODO
//    //    List<LibraryUser> users = userService.findAll();
//    //    map.addAttribute("users", users);
//    System.out.println("DOING!!");
//    return "user_info";
//  }

//  @GetMapping("register")
//  public String startRegistration(ModelMap map) {
//    map.put("user", new LibraryUser());
//    return "registration";
//  }
}
