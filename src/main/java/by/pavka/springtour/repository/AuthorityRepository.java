package by.pavka.springtour.repository;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Override
    List<Authority> findAll();

    @Override
    <S extends Authority> S save(S entity);

    @Override
    Optional<Authority> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    void deleteByUsername(String username);

}
