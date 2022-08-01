package by.pavka.springtour.repository;

import by.pavka.springtour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Override
    <S extends Tour> S save(S entity);

    @Override
    Optional<Tour> findById(Integer integer);

    @Override
    List<Tour> findAll();

    @Query(value="Select * from tours WHERE tour_status = 'VALID' " +
            "OR tour_status = 'HOT' OR tour_status = 'RUNNING'", nativeQuery = true)
    List<Tour> findAllValid();

    @Override
    void deleteById(Integer integer);

    @Modifying
    @Query(value="UPDATE tours SET booked = booked + 1 WHERE booked < capacity AND id = :tourId"
            , nativeQuery = true)
    int incrementBooking(@Param("tourId") int tourId);

    @Modifying
    @Query(value="UPDATE tours SET booked = booked - 1 WHERE booked > 0 AND id = :tourId"
            , nativeQuery = true)
    int decrementBooking(@Param("tourId") int tourId);

}
