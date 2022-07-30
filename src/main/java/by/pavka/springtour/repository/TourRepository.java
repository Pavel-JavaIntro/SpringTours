package by.pavka.springtour.repository;

import by.pavka.springtour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Override
    <S extends Tour> S save(S entity);

    @Override
    Optional<Tour> findById(Integer integer);

    @Override
    List<Tour> findAll();

    @Override
    void deleteById(Integer integer);
}
