package by.pavka.springtour.repository;

import by.pavka.springtour.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
    @Override
    <S extends LibraryUser> S save(S entity);

    @Override
    Optional<LibraryUser> findById(Integer integer);

    @Override
    List<LibraryUser> findAll();

    @Override
    void deleteById(Integer integer);

    void deleteByUsername(String username);

    Optional<LibraryUser> getByUsername(String username);
}
