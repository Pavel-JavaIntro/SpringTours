package by.pavka.springtour.service;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository repository;

    public List<Authority> getAll() {
        return repository.findAll();
    }

    public Optional<Authority> get(int i) {
        return repository.findById(i);
    }

    public Authority save(Authority authority) {
        return repository.save(authority);
    }

    public void delete(int i) {
        repository.deleteById(i);
    }

    public void deleteByUsername(String username) {
        repository.deleteByUsername(username);
    }
}
