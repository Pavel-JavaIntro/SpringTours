package by.pavka.springtour.repository;

import by.pavka.springtour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {
}
