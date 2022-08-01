package by.pavka.springtour.repository;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.TourType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TourTypeRepository extends JpaRepository<TourType, Integer> {
    @Override
    <S extends TourType> S save(S entity);

    @Override
    Optional<TourType> findById(Integer integer);

    @Override
    List<TourType> findAll();

    @Override
    void deleteById(Integer integer);

}
