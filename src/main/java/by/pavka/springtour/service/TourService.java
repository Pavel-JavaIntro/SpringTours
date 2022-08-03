package by.pavka.springtour.service;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourStatus;
import by.pavka.springtour.repository.LibraryUserRepository;
import by.pavka.springtour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {

  @Autowired TourRepository repository;

  public List<Tour> getAll() {
    return repository.findAll();
  }

  public List<Tour> getAllValid() {
    return repository.findAllValid();
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

  public int incrementBooking(int id) {
    return repository.incrementBooking(id);
  }

  public int decrementBooking(int id) {
    return repository.decrementBooking(id);
  }

  public List<Tour> findByTourStatusAndStartDate(TourStatus tourStatus, Date date) {
    return repository.findByTourStatusAndStartDateLessThanEqual(tourStatus, date);
  }

  public List<Tour> findByTourStatusAndEndDate(TourStatus tourStatus, Date date) {
    return repository.findByTourStatusAndEndDateLessThanEqual(tourStatus, date);
  }

  public void setRunning(int i) {
    repository.setRunning(i);
  }

  public void setExpired(int i) {
    repository.setExpired(i);
  }
}
