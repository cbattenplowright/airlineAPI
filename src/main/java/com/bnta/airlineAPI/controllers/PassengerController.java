package com.bnta.airlineAPI.controllers;

import com.bnta.airlineAPI.models.Passenger;
import com.bnta.airlineAPI.repositories.PassengerRepository;
import com.bnta.airlineAPI.services.FlightService;
import com.bnta.airlineAPI.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//    GET localhost:8080/passengers

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//    GET localhost:8080/passengers/id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

}
