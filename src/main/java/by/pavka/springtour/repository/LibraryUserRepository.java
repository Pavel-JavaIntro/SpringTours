package by.pavka.springtour.repository;

import by.pavka.springtour.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
}
