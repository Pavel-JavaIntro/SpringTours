package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("springbookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public String showAllBookings(@Nullable @RequestParam String[] bookId, ModelMap map) {
        List<Booking> bookings = bookingService.getAll();
        if (bookId != null) {
            List<String> bookIds = Arrays.asList(bookId);
            for (Booking b : bookings) {
                if (bookIds.contains(b.getId() + "")) {
                    b.setPaid(true);
                } else {
                    b.setPaid(false);
                }
                bookingService.save(b);
            }
        }
        map.addAttribute("bookings", bookings);
        return "booking_listing";
    }
}
