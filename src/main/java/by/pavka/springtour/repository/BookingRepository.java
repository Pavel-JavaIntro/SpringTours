package by.pavka.springtour.repository;

import by.pavka.springtour.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    <S extends Booking> S save(S entity);

    @Override
    Optional<Booking> findById(Integer integer);

    @Override
    List<Booking> findAll();

    @Override
    void deleteById(Integer integer);
}
