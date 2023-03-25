package com.example.backend.controllers;
import com.example.backend.models.Country;
import com.example.backend.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public List
    getAllCountries() {
        return countryRepository.findAll();
    }

    @PostMapping("/countries")
    public ResponseEntity<Object> createCountry(@RequestBody Country country) {
        Country nc = countryRepository.save(country);
        return new ResponseEntity<Object>(nc, HttpStatus.OK);
    }
}

