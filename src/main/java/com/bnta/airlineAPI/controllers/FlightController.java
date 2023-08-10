package com.bnta.airlineAPI.controllers;

import com.bnta.airlineAPI.models.Flight;
import com.bnta.airlineAPI.models.FlightDTO;
import com.bnta.airlineAPI.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

//    GET localhost:8080/flights
//    INDEX
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

//    GET localhost:8080/flights/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable Long id){
        return new ResponseEntity(flightService.getFlightById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody FlightDTO flightDTO){
        return new ResponseEntity<>(flightService.addFlight(flightDTO), HttpStatus.CREATED);
    }
}
