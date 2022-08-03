package by.pavka.springtour.repository;

import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
            "OR tour_status = 'RUNNING'", nativeQuery = true)
    List<Tour> findAllValid();

    @Override
    void deleteById(Integer integer);

    List<Tour> findByTourStatusAndStartDateLessThanEqual(TourStatus tourStatus, Date date);

    List<Tour> findByTourStatusAndEndDateLessThanEqual(TourStatus tourStatus, Date date);

    @Modifying
    @Transactional
    @Query(value="UPDATE tours SET booked = booked + 1 WHERE booked < capacity AND id = :tourId"
            , nativeQuery = true)
    int incrementBooking(@Param("tourId") int tourId);

    @Modifying
    @Transactional
    @Query(value="UPDATE tours SET booked = booked - 1 WHERE booked > 0 AND id = :tourId"
            , nativeQuery = true)
    int decrementBooking(@Param("tourId") int tourId);

    @Modifying
    @Transactional
    @Query(value="UPDATE tours set tour_status = 'RUNNING' WHERE id = :tourId"
    , nativeQuery = true)
    void setRunning(@Param("tourId") int tourId);

    @Modifying
    @Transactional
    @Query(value="UPDATE tours set tour_status = 'EXPIRED' WHERE id = :tourId"
            , nativeQuery = true)
    void setExpired(@Param("tourId") int tourId);
}
