package by.pavka.springtour.service;

import by.pavka.springtour.model.Booking;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.repository.BookingRepository;
import by.pavka.springtour.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public List<Booking> getAll() {
        return repository.findAll();
    }

    public Optional<Booking> get(int i) {
        return repository.findById(i);
    }

    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    public void delete(int i) {
        repository.deleteById(i);
    }
}
