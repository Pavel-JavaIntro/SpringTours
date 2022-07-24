package by.pavka.springtour.repository;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.TourType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourTypeRepository extends JpaRepository<TourType, Integer> {
}
