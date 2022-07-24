package by.pavka.springtour.repository;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
