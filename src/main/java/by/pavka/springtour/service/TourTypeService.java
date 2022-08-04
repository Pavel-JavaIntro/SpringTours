package by.pavka.springtour.service;

import by.pavka.springtour.model.TourType;
import by.pavka.springtour.repository.TourTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourTypeService {

    @Autowired
    TourTypeRepository repository;

    @Cacheable("types")
    public List<TourType> getAll() {
        return repository.findAll();
    }

    @CachePut("types")
    public Optional<TourType> get(int i) {
        return repository.findById(i);
    }

    @CachePut("types")
    public TourType save(TourType type) {
        return repository.save(type);
    }

    public void delete(int i) {
        repository.deleteById(i);
    }
}
