package com.wildcodeschool.traveldiary.controllers;

import com.wildcodeschool.traveldiary.entities.Destination;
import com.wildcodeschool.traveldiary.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    // This method returns HTTP response and in the body of HTTP response it will return a list of all destinations
    @GetMapping("/all")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> allDestinations = destinationService.getAll();
        return new ResponseEntity<>(allDestinations, HttpStatus.OK); // That way the user will know that they get a 200 response and it works
    }

    // Method and route to show details of each destination
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable("id") Integer id) {
        Destination destination = destinationService.getById(id);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    // Method used for creating a new destination
    // We expects the whole object Destination that is gonna be in JSON format created by the user
    // "consumes" element in Spring is used to indicate the media type format supported by API request
    @PostMapping(value = "/create", consumes = {"application/xml","application/json"})
    public ResponseEntity<Destination>  createDestination(@RequestBody Destination destination) {
        Destination newDestination = destinationService.add(destination);
        return new ResponseEntity<>(newDestination, HttpStatus.CREATED);
    }

    // Method used for updating the infos of a destination
    @PutMapping(value = "/update/", consumes = {"application/xml","application/json"})
    public ResponseEntity<Destination> updateDestination(@RequestBody Destination destination) {
        // Save the infos modified into database
        Destination updatedDestination = destinationService.update(destination);
        return new ResponseEntity<>(updatedDestination, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDestination(@PathVariable("id") Integer id) {
        destinationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Method created to read all existing destinations
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Destination>> getDestinations(@RequestParam(name="keyWords", defaultValue = "") String keyword,
                                             @RequestParam(name="page", defaultValue = "0") int page,
                                             @RequestParam(name="size", defaultValue = "10")int size) {

        Pageable sortedByNameAsc = PageRequest.of(0, 5, Sort.by("country"));
        Page<Destination> pageDestinations = destinationService.searchDestinations(keyword, page, size);
        return new ResponseEntity<>(pageDestinations, HttpStatus.OK);
    }
}
