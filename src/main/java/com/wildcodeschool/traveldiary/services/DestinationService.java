package com.wildcodeschool.traveldiary.services;

import com.wildcodeschool.traveldiary.entities.Destination;
import com.wildcodeschool.traveldiary.exceptions.UserNotFoundException;
import com.wildcodeschool.traveldiary.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public Destination add(Destination destination) {
        return destinationRepository.save(destination);
    }

    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    public Destination getById(Integer id) {
        return destinationRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("The user with the id: " + id + " does not exist."));
    }

    public Destination update(Destination destination) {
        destination.setId(destination.getId());
        return destinationRepository.save(destination);
    }

    public void delete(Integer id) {
        destinationRepository.deleteById(id);
    }

    public Page<Destination> searchDestinations(@RequestParam(name="keyWords", defaultValue = "") String keyword,
                                             @RequestParam(name="page", defaultValue = "0") int page,
                                             @RequestParam(name="size", defaultValue = "10")int size) {

        Pageable sortedByNameAsc = PageRequest.of(0, 5, Sort.by("country"));
        return destinationRepository.search("%" + keyword +"%", sortedByNameAsc);
    }
}
