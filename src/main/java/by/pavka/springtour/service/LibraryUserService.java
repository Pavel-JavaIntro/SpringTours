package by.pavka.springtour.service;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class LibraryUserService {

    @Autowired
    LibraryUserRepository repository;

    public List<LibraryUser> findAll() {
        return repository.findAll();
    }
}
