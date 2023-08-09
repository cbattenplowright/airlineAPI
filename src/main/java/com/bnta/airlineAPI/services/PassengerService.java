package com.bnta.airlineAPI.services;

import com.bnta.airlineAPI.models.Passenger;
import com.bnta.airlineAPI.repositories.FlightRepository;
import com.bnta.airlineAPI.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id){
        return passengerRepository.findById(id).get();
    }

}
