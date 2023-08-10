package com.bnta.airlineAPI.services;

import com.bnta.airlineAPI.models.Flight;
import com.bnta.airlineAPI.models.FlightDTO;
import com.bnta.airlineAPI.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight addFlight(FlightDTO flightDTO){
        Flight newFlight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        return flightRepository.save(newFlight);
    }
}
