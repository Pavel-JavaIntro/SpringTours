package by.pavka.springtour.service;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.repository.LibraryUserRepository;
import by.pavka.springtour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    @Autowired
    TourRepository repository;

    public List<Tour> getAll() {
        return repository.findAll();
    }

    public Optional<Tour> get(int i) {
        return repository.findById(i);
    }

    public Tour save(Tour tour) {
        return repository.save(tour);
    }

    public void delete(int i) {
        repository.deleteById(i);
    }
}
